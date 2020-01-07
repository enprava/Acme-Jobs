
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.dashboard.Dashboard;
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

		request.unbind(entity, model, "ratJobsWithChallenge2", "ratChallenge2WithAnswer", "ratApplicationsWithPasswords");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		Dashboard result = new Dashboard();
		Double ratJobsWithChallenge2; //TODO: E3
		Double ratChallenges2WithAnswer; //TODO: E3
		Double ratApplicationsWithPassword; //TODO: E3
		Double nChallenges2;
		Double nChallenges2WithAnswer;
		Double nAnswersWithPassword;
		Double nJobs;
		Double nApplications;

		nChallenges2 = this.repository.findNumberOfChallenges2();
		nChallenges2WithAnswer = this.repository.findNumberOfChallenges2WithAnswer();
		nAnswersWithPassword = this.repository.findNumberOfAnswersWithPassword();
		nJobs = this.repository.findNumberOfJobs();
		nApplications = this.repository.findNumberOfApplications();
		ratJobsWithChallenge2 = nChallenges2 / nJobs;
		ratChallenges2WithAnswer = nChallenges2WithAnswer / nChallenges2;
		ratApplicationsWithPassword = nAnswersWithPassword / nApplications;

		result.setRatJobsWithChallenge2(ratJobsWithChallenge2);
		result.setRatChallenge2WithAnswer(ratChallenges2WithAnswer);
		result.setRatApplicationsWithPasswords(ratApplicationsWithPassword);
		return result;
	}

}
