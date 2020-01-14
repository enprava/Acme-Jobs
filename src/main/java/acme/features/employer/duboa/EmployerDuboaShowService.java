
package acme.features.employer.duboa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duboas.Duboa;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerDuboaShowService implements AbstractShowService<Employer, Duboa> {

	@Autowired
	EmployerDuboaRepository repository;


	@Override
	public boolean authorise(final Request<Duboa> request) {
		assert request != null;

		boolean result;
		int jobId;
		Job job;
		Employer employer;
		Principal principal;

		jobId = request.getModel().getInteger("jobId");
		job = this.repository.findOneJobById(jobId);
		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = /* job.isFinalMode() || !job.isFinalMode() && */ employer.getUserAccount().getId() == principal.getAccountId();
		return result;
	}

	@Override
	public void unbind(final Request<Duboa> request, final Duboa entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "trackId");

	}

	@Override
	public Duboa findOne(final Request<Duboa> request) {
		Duboa res = new Duboa();

		int jobId = request.getModel().getInteger("jobId");
		res = this.repository.findDuboaByJobId(jobId);

		return res;
	}

}
