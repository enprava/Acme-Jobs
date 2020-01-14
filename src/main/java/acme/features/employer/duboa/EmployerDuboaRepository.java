
package acme.features.employer.duboa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.duboas.Duboa;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerDuboaRepository extends AbstractRepository {

	@Query("select d from Duboa d where d.job.id = ?1")
	Duboa findDuboaByJobId(int jobId);

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

}
