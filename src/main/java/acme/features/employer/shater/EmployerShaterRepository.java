
package acme.features.employer.shater;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.shaters.Shater;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerShaterRepository extends AbstractRepository {

	@Query("select s from Shater s where s.job.id = ?1")
	Shater findOneByJobId(int jobId);
}
