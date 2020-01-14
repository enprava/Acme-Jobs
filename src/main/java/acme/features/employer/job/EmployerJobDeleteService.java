
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.duboas.Duboa;
import acme.entities.duties.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class EmployerJobDeleteService implements AbstractDeleteService<Employer, Job> {

	@Autowired
	private EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		// TODO Auto-generated method stub
		assert request != null;

		boolean result = false;
		boolean aux = false;
		boolean aux2 = false;
		int jobId;

		jobId = request.getModel().getInteger("id");
		Collection<Application> applications = this.repository.applicationsByJobId(jobId);
		aux = applications.isEmpty();

		if (request.getPrincipal().hasRole(Employer.class)) {
			aux2 = true;
		}
		result = aux && aux2;
		return result;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "finalMode");
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "title", "deadline");
	}

	@Override
	public Job findOne(final Request<Job> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Job result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneJobById(id);

		return result;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<Job> request, final Job entity) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;

		int jobId;

		jobId = request.getModel().getInteger("id");
		Collection<Duty> duties = this.repository.findManyDutiesByJobId(jobId);
		Duboa c = this.repository.findDuboaByJobId(jobId);

		this.repository.deleteAll(duties);
		if (c != null) {
			this.repository.delete(c);
		}
		this.repository.delete(entity);

	}

}
