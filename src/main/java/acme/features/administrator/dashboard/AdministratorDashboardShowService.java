
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.dashboards.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ratioOfJobsWithDuboa", "ratioOfDuboaWithTrackId", "ratioOfApplicationsWithPassword");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		Dashboard result = new Dashboard();
		Double ratioOfJobsWithDuboa;
		Double ratioOfDuboaWithTrackId;
		Double ratioOfApplicationsWithPassword;
		Double numberOfDuboa;
		Double numberOfDuboaWithTrackId;
		Double numberOfAnswersWithPassword;
		Double numberOfJobs;
		Double numberOfApplications;

		numberOfDuboa = this.repository.findNumberOfDuboa();
		numberOfDuboaWithTrackId = this.repository.findNumberOfDuboaWithTrackId();
		numberOfAnswersWithPassword = this.repository.findNumberOfAnswersWithPassword();
		numberOfJobs = this.repository.findNumberOfJobs();
		numberOfApplications = this.repository.findNumberOfApplications();
		ratioOfJobsWithDuboa = numberOfDuboa / numberOfJobs;
		ratioOfDuboaWithTrackId = numberOfDuboaWithTrackId / numberOfDuboa;
		ratioOfApplicationsWithPassword = numberOfAnswersWithPassword / numberOfApplications;

		result.setRatioOfJobsWithDuboa(ratioOfJobsWithDuboa);
		result.setRatioOfDuboaWithTrackId(ratioOfDuboaWithTrackId);
		result.setRatioOfApplicationsWithPassword(ratioOfApplicationsWithPassword);

		return result;
	}

}
