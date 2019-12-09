
package acme.features.worker.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerJobShowService implements AbstractShowService<Worker, Job> {

	@Autowired
	WorkerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		// TODO Auto-generated method stub
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline");
		request.unbind(entity, model, "salary", "moreInfo", "description", "finalMode");

	}

	@Override
	public Job findOne(final Request<Job> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Job result;
		Application aux;
		int id;

		id = request.getModel().getInteger("applicationId");
		aux = this.repository.findOneJobByApplicationId(id);
		result = aux.getJob();
		return result;
	}

}
