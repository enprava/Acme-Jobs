
package acme.features.employer.duty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duties.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerDutyCreateService implements AbstractCreateService<Employer, Duty> {

	@Autowired
	private EmployerDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		// TODO Auto-generated method stub
		assert request != null;

		boolean result = false;
		boolean aux = false;
		boolean aux2 = false;

		int jobId;
		Job job;

		jobId = request.getModel().getInteger("jobId");
		job = this.repository.findJobById(jobId);
		aux2 = !job.isFinalMode();

		if (request.getPrincipal().hasRole(Employer.class)) {
			aux = true;
		}

		result = aux && aux2;

		return result;
	}

	@Override
	public void bind(final Request<Duty> request, final Duty entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("jobId", request.getModel().getInteger("jobId"));

		request.unbind(entity, model, "title", "percentage", "description");

	}

	@Override
	public Duty instantiate(final Request<Duty> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Duty result;
		result = new Duty();
		int jobId = request.getModel().getInteger("jobId");
		Job aux = this.repository.findJobById(jobId);

		result.setJob(aux);

		return result;
	}

	@Override
	public void validate(final Request<Duty> request, final Duty entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Duty> request, final Duty entity) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
