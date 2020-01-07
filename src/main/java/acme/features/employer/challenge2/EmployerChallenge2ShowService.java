
package acme.features.employer.challenge2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges2.Challenge2;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerChallenge2ShowService implements AbstractShowService<Employer, Challenge2> {

	@Autowired
	EmployerChallenge2Repository repository;


	@Override
	public boolean authorise(final Request<Challenge2> request) {
		assert request != null;

		boolean result;
		int jobId;
		Challenge2 c2;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("jobId");
		c2 = this.repository.findOneChallenge2ByJobId(jobId);
		employer = c2.getJob().getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();
		return result;
	}

	@Override
	public void unbind(final Request<Challenge2> request, final Challenge2 entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "description", "moreInfo");

	}

	@Override
	public Challenge2 findOne(final Request<Challenge2> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Challenge2 result;

		int jobId = request.getModel().getInteger("jobId");
		result = this.repository.findOneChallenge2ByJobId(jobId);
		return result;
	}

}
