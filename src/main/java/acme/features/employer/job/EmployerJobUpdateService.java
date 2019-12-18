
package acme.features.employer.job;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.duties.Duty;
import acme.entities.jobs.Job;
import acme.entities.parameters.Parameter;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerJobUpdateService implements AbstractUpdateService<Employer, Job> {

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
		Job job;

		jobId = request.getModel().getInteger("id");
		job = this.repository.findOneJobById(jobId);
		aux2 = !job.isFinalMode();

		if (request.getPrincipal().hasRole(Employer.class)) {
			aux = true;
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

		request.bind(entity, errors);
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

		int jobId = request.getModel().getInteger("id");

		if (entity.isFinalMode()) {
			Collection<Duty> duties = this.repository.findManyDutiesByJobId(jobId);

			if (!duties.isEmpty()) {
				Double sum = this.repository.sumDutiesPercentageByJobId(jobId);
				errors.state(request, sum == 100, "reference", "employer.job.form.error.dutiesNotSum100");
			} else {
				errors.state(request, duties != null, "reference", "employer.job.form.error.dutiesIsNull");
			}

		}

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
			errors.state(request, !aux || reference.equals(request.getModel().getString("reference")), "reference", "employer.job.form.error.referenceInUse");
		}

	}

	@Override
	public void update(final Request<Job> request, final Job entity) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
