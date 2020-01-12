
package acme.features.worker.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.answer.Answer;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerAnswerShowService implements AbstractShowService<Worker, Answer> {

	@Autowired
	WorkerAnswerRepository repository;


	@Override
	public boolean authorise(final Request<Answer> request) {
		assert request != null;

		return true;
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
		assert request != null;

		Answer result;
		int applicationId;

		applicationId = request.getModel().getInteger("applicationId");
		result = this.repository.findApplicationByApplicationId(applicationId);
		return result;
	}

}
