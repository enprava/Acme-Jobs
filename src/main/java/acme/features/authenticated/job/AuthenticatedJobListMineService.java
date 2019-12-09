
package acme.features.authenticated.job;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedJobListMineService implements AbstractListService<Authenticated, Job> {

	@Autowired
	AuthenticatedJobRepository repository;


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
	}

	@Override
	public Collection<Job> findMany(final Request<Job> request) {
		// TODO Auto-generated method stub
		assert request != null;

		Collection<Job> result;

		Calendar aux = Calendar.getInstance();

		Date date2 = new Date();
		aux.setTime(date2);

		result = this.repository.findManyJobsActives(aux.getTime());
		return result;
	}

}
