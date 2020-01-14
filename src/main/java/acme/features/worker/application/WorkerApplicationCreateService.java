
package acme.features.worker.application;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.util.UrlUtils;
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
		if (this.repository.findDuboaByJobId(id) != null) {
			model.setAttribute("hasDuboa", true);
		} else {
			model.setAttribute("hasDuboa", false);
		}

		request.unbind(entity, model, "referenceNumber", "statement", "skills", "qualifications");

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

		if (request.getModel().getBoolean("hasDuboa")) {
			errors.state(request, !(request.getModel().getAttribute("password").toString().trim() != "" && request.getModel().getAttribute("answer").toString().trim() == ""), "answer", "worker.job.form.error.invalidAnswer");
			errors.state(request, !(request.getModel().getAttribute("password").toString().trim() != "" && request.getModel().getAttribute("trackId").toString().trim() == ""), "trackId", "worker.job.form.error.invalidTrackId");
			errors.state(request, !(request.getModel().getAttribute("trackId").toString().trim() != "" && request.getModel().getAttribute("answer").toString().trim() == ""), "trackId", "worker.job.form.error.invalidTrackId");

			errors.state(request, request.getModel().getString("password").matches("^(?=(?:.*\\d){1,})(?=(?:.*[a-zA-Z]){1,})(?=(?:.*\\p{Punct}){1,}).{10,}$|^$"), "password", "worker.application.form.error.invalidPassword");
			if (request.getModel().getAttribute("trackId") != null && request.getModel().getAttribute("trackId").toString().trim() != "") {
				errors.state(request, UrlUtils.isAbsoluteUrl(request.getModel().getAttribute("trackId").toString()), "trackId", "worker.application.form.error.invalidTrackId");

			}

		}
	}

	@Override
	public void create(final Request<Application> request, final Application entity) {

		assert request != null;
		assert entity != null;

		this.repository.save(entity);

		if (request.getModel().getBoolean("hasDuboa")) {
			if (!request.getModel().getAttribute("answer").toString().isEmpty()) {
				Answer a = new Answer();

				String aux = request.getModel().getAttribute("answer").toString();
				String aux2 = request.getModel().getAttribute("password").toString();
				String aux3 = request.getModel().getAttribute("trackId").toString();

				a.setAnswer(aux);
				a.setPassword(aux2);
				a.setTrackId(aux3);
				a.setApplication(entity);
				this.repository.save(a);
			}
		}
	}
}
