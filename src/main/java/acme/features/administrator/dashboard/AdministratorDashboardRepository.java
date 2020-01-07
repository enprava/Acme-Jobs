
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(c) from Challenge2 c")
	Double findNumberOfChallenges2();

	@Query("select count(c) from Challenge2 c where c.job in (select a.application.job from Answer a)")
	Double findNumberOfChallenges2WithAnswer();

	@Query("select count(a) from Answer a where a.password != ''")
	Double findNumberOfAnswersWithPassword();

	@Query("SELECT count (a) from Application a")
	Double findNumberOfApplications();

	@Query("SELECT count (j) from Job j")
	Double findNumberOfJobs();
}
