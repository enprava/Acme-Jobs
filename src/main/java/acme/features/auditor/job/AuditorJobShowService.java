
package acme.features.auditor.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Service;

import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuditorJobShowService implements AbstractShowService<Auditor, Job> {

	@Autowired
	AuditorJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		int jobId;
		boolean result;
		Job job;
		Auditor auditor;
		Principal principal;
		jobId = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(jobId);
		//		auditor = job.
		//		result =
		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline");
	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;
		Job res;
		int id;
		id = request.getModel().getInteger("id");
		res = this.repository.findOneJobById(id);
		return res;
	}

}
