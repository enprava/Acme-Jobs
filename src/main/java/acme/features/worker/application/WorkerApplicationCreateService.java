
package acme.features.worker.application;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.answers.Answer;
import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerApplicationCreateService implements AbstractCreateService<Worker, Application> {

	@Autowired
	WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean result;
		int jobId;
		Job job;

		jobId = request.getModel().getInteger("jobId");
		job = this.repository.findJobPublished(jobId);

		Date date = job.getDeadline();
		Date now = new Date();
		Boolean bool = date.after(now);

		result = job.isFinalMode() && bool == true && request.getPrincipal().hasRole(Worker.class);
		return result;

	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationMoment", "status", "job", "worker");

	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("jobId", request.getModel().getInteger("jobId"));
		int id;
		id = request.getModel().getInteger("jobId");
		if (this.repository.findOneChallenge2ByJobId(id) != null) {
			model.setAttribute("hasChallenge2", true);
		} else {
			model.setAttribute("hasChallenge2", false);
		}

		request.unbind(entity, model, "referenceNumber", "statement", "skills", "qualifications", "answerPasswordApp");

	}

	@Override
	public Application instantiate(final Request<Application> request) {
		Application result;
		result = new Application();

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		result.setCreationMoment(moment);

		Job job;
		int jobId;
		jobId = request.getModel().getInteger("jobId");
		job = this.repository.findJobPublished(jobId);
		result.setJob(job);

		String status = "pending";
		result.setStatus(status);

		Worker worker;
		Integer workerId;
		workerId = request.getPrincipal().getActiveRoleId();
		worker = this.repository.findWorkerById(workerId);
		result.setWorker(worker);

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		if (request.getModel().getBoolean("hasChallenge2")) {
			errors.state(request, !(request.getModel().getAttribute("answerPassword").toString().trim() != "" && request.getModel().getAttribute("answerAnswer").toString().trim() == ""), "answerAnswer", "worker.answer.form.error.answerNeeded");
			errors.state(request, request.getModel().getString("answerPassword").matches("^(?=(?:.*\\d){3,})(?=(?:.*[a-zA-Z]){3,})(?=(?:.*\\p{Punct}){3,}).{8,}$|^$"), "answerPassword", "worker.answer.form.error.incorrectPassword");
		}
	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

		if (request.getModel().getBoolean("hasChallenge2")) {
			String aux1 = request.getModel().getAttribute("answerAnswer").toString();
			String aux2 = request.getModel().getAttribute("answerPassword").toString();
			Answer a = new Answer();

			if (request.getModel().getAttribute("answerAnswer") != null && aux1.trim() != "") {
				a.setAnswer(aux1);
				a.setPassword(aux2);
				a.setApplication(entity);

				this.repository.save(a);
			}
		}
	}
}
