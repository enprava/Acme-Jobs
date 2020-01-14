
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(c) from Duboa c")
	Double findNumberOfDuboa();

	@Query("select count(c) from Duboa c where c.trackId!= ''") // in (select a.application.job from Answer a)")
	Double findNumberOfDuboaWithTrackId();

	@Query("select count(a) from Answer a where a.password != ''")
	Double findNumberOfAnswersWithPassword();

	@Query("select count (a) from Application a")
	Double findNumberOfApplications();

	@Query("select count (j) from Job j")
	Double findNumberOfJobs();

}
