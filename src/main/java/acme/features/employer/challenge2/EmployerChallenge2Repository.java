
package acme.features.employer.challenge2;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.challenges2.Challenge2;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerChallenge2Repository extends AbstractRepository {

	@Query("select c from Challenge2 c where c.id = ?1")
	Challenge2 findOneChallenge2ById(int id);

	@Query("select c from Challenge2 c where c.job.id = ?1")
	Challenge2 findOneChallenge2ByJobId(int jobId);

}
