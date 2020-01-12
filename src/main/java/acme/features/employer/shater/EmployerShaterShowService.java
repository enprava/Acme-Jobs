
package acme.features.employer.shater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Employer;
import acme.entities.shaters.Shater;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerShaterShowService implements AbstractShowService<Employer, Shater> {

	@Autowired
	EmployerShaterRepository repository;


	@Override
	public boolean authorise(final Request<Shater> request) {
		// TODO Auto-generated method stub
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Shater> request, final Shater entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "trackId", "description");

	}

	@Override
	public Shater findOne(final Request<Shater> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Shater result;
		int jobId;

		jobId = request.getModel().getInteger("jobId");

		result = this.repository.findOneByJobId(jobId);
		return result;
	}

}
