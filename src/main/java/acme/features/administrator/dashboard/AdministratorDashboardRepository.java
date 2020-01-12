
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(s) from Shater s")
	Double findNumberJobWithChallenges();

	@Query("select count(s) from Shater s where s.trackId != ''")
	Double findNumberShaterWithTrackId();

	@Query("select count(a) from Answer a where a.password != ''")
	Double findNumberAnswersProtected();

	@Query("SELECT count (a) from Application a")
	Double findNumberApplications();

	@Query("SELECT count (j) from Job j")
	Double findNumberJobs();
}
