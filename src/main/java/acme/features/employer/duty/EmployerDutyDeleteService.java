
package acme.features.employer.duty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duties.Duty;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class EmployerDutyDeleteService implements AbstractDeleteService<Employer, Duty> {

	@Autowired
	private EmployerDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		// TODO Auto-generated method stub
		assert request != null;
		boolean result = false;
		boolean aux = false;

		if (request.getPrincipal().hasRole(Employer.class)) {
			aux = true;
		}

		result = aux;
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

		request.unbind(entity, model, "title", "percentage", "description");

	}

	@Override
	public Duty findOne(final Request<Duty> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Duty result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneDutyById(id);

		return result;
	}

	@Override
	public void validate(final Request<Duty> request, final Duty entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

		errors.state(request, !entity.getJob().isFinalMode(), "description", "employer.duty.form.error.jobInFinalMode");

	}

	@Override
	public void delete(final Request<Duty> request, final Duty entity) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);

	}

}
