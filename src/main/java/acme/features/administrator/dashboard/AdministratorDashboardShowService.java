
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;
import forms.Dashboard;

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

		request.unbind(entity, model, "jobsWithShater", "shaterWithTrackId", "applicationsProtected");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {

		Dashboard result = new Dashboard();

		Double ratioOfJobsWithChallenge, ratioOfChallengesWithAnswer, ratioOfApplicationsProtected, numberJobChallenges, numberJobChallengesWithAnswer, numberAnswersProtected, jobs, applications;

		numberJobChallenges = this.repository.findNumberJobWithChallenges();
		numberJobChallengesWithAnswer = this.repository.findNumberShaterWithTrackId();
		numberAnswersProtected = this.repository.findNumberAnswersProtected();
		jobs = this.repository.findNumberJobs();
		applications = this.repository.findNumberApplications();
		ratioOfJobsWithChallenge = numberJobChallenges / jobs;
		ratioOfChallengesWithAnswer = numberJobChallengesWithAnswer / numberJobChallenges;
		ratioOfApplicationsProtected = numberAnswersProtected / applications;

		result.setJobsWithShater(ratioOfJobsWithChallenge);
		result.setShaterWithTrackId(ratioOfChallengesWithAnswer);
		result.setApplicationsProtected(ratioOfApplicationsProtected);
		return result;
	}

}
