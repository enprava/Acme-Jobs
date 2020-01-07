
package acme.features.worker.challenge2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges2.Challenge2;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerChallenge2ShowService implements AbstractShowService<Worker, Challenge2> {

	@Autowired
	WorkerChallenge2Repository repository;


	@Override
	public boolean authorise(final Request<Challenge2> request) {
		assert request != null;
		return true;
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
