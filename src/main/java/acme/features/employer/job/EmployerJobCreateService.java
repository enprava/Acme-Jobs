
package acme.features.employer.job;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.parameters.Parameter;
import acme.entities.roles.Employer;
import acme.entities.shaters.Shater;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerJobCreateService implements AbstractCreateService<Employer, Job> {

	@Autowired
	private EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
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
	public Job instantiate(final Request<Job> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Job result;
		result = new Job();

		Principal principal = request.getPrincipal();
		int UserAccountId = principal.getAccountId();
		Employer employer = this.repository.findEmployerByUserAccountId(UserAccountId);

		result.setEmployer(employer);

		return result;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("deadline")) {
			Calendar calendar;
			Date minimumDeadline;
			calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			minimumDeadline = calendar.getTime();
			errors.state(request, entity.getDeadline().after(minimumDeadline), "deadline", "employer.job.form.error.invaliddeadline");
		}

		if (!errors.hasErrors("description")) {
			Parameter p = this.repository.findParameters();
			String spamWords = p.getSpamwords();
			Double spamThreshold = p.getSpamthreshold();
			String description = entity.getDescription();
			errors.state(request, !parameterMethods.isSpam(description, spamWords, spamThreshold), "description", "employer.job.form.error.spamDescription");
		}

		if (!errors.hasErrors("reference")) {
			Collection<Job> jobs = this.repository.findAllJobs();
			String reference = entity.getReference();
			boolean aux = jobs.stream().map(x -> x.getReference()).anyMatch(x -> x.equals(reference));
			errors.state(request, !aux, "reference", "employer.job.form.error.referenceInUse");
		}

		if (!request.getModel().getString("sdescription").isEmpty() || !request.getModel().getString("trackId").isEmpty()) {

			if (!errors.hasErrors("description")) {
				String description = request.getModel().getAttribute("sdescription").toString();
				boolean aux = description.length() >= 256;
				errors.state(request, !aux, "description", "employer.job.form.error.shaterDescription");
			}

			if (!errors.hasErrors("shaterDescription")) {
				String description = request.getModel().getAttribute("sdescription").toString();
				boolean aux = description.length() == 0;
				errors.state(request, !aux, "description", "employer.job.form.error.shaterDescription.blank");
			}
		}

	}

	@Override
	public void create(final Request<Job> request, final Job entity) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;

		entity.setFinalMode(false);
		this.repository.save(entity);

		if (!request.getModel().getAttribute("sdescription").toString().isEmpty()) {
			Shater shater = new Shater();

			String description = request.getModel().getAttribute("sdescription").toString();
			String trackId = request.getModel().getAttribute("trackId").toString();

			shater.setDescription(description);
			shater.setTrackId(trackId);
			shater.setJob(entity);
			this.repository.save(shater);
		}

	}

}
