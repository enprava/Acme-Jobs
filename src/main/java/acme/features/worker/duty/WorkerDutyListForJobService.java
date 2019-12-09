
package acme.features.worker.duty;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duties.Duty;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class WorkerDutyListForJobService implements AbstractListService<Worker, Duty> {

	@Autowired
	WorkerDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		// TODO Auto-generated method stub
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "percentage");
	}

	@Override
	public Collection<Duty> findMany(final Request<Duty> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Collection<Duty> result;
		int id = request.getModel().getInteger("jobId");

		result = this.repository.findManyByJobId(id);
		return result;
	}

}
