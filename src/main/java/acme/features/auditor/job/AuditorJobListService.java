
package acme.features.auditor.job;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Service;

import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuditorJobListService implements AbstractListService<Auditor, Job> {

	@Autowired
	AuditorJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;
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
	public Collection<Job> findMany(final Request<Job> request) {
		assert request != null;
		Collection<Job> res;
		Principal principal;

		principal = request.getPrincipal();
		res = this.repository.findManyByAuditorId(principal.getActiveRoleId());
		return res;
	}

}
