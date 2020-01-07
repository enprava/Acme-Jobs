
package acme.features.employer.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.answers.Answer;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerAnswerShowService implements AbstractShowService<Employer, Answer> {

	@Autowired
	EmployerAnswerRepository repository;


	@Override
	public boolean authorise(final Request<Answer> request) {
		assert request != null;

		boolean result;
		int appId;
		Answer a;
		Employer employer;
		Principal principal;

		appId = request.getModel().getInteger("appId");
		a = this.repository.findOneAnswerByApplicationId(appId);
		employer = a.getApplication().getJob().getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();
		return result;
	}

	@Override
	public void unbind(final Request<Answer> request, final Answer entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "answer", "password");

	}

	@Override
	public Answer findOne(final Request<Answer> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Answer result;

		int appId = request.getModel().getInteger("appId");
		result = this.repository.findOneAnswerByApplicationId(appId);
		return result;
	}

}
