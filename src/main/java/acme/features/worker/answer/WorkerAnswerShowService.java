
package acme.features.worker.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.answers.Answer;
import acme.entities.applications.Application;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerAnswerShowService implements AbstractShowService<Worker, Answer> {

	@Autowired
	WorkerAnswerRepository repository;


	@Override
	public boolean authorise(final Request<Answer> request) {
		assert request != null;

		boolean result;
		int applicationId;
		Application application;
		Worker worker;
		Principal principal;

		applicationId = request.getModel().getInteger("applicationId");
		application = this.repository.findOneApplicationById(applicationId);
		worker = application.getWorker();
		principal = request.getPrincipal();
		result = worker.getUserAccount().getId() == principal.getAccountId();
		return result;
	}

	@Override
	public void unbind(final Request<Answer> request, final Answer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "answer", "password", "trackId");

	}

	@Override
	public Answer findOne(final Request<Answer> request) {
		Answer res = new Answer();

		int applicationId = request.getModel().getInteger("applicationId");
		res = this.repository.findAnswerByApplicationId(applicationId);

		return res;
	}

}
