
package acme.features.worker.job;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.challenges2.Challenge2;
import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerJobRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = ?1")
	Application findOneJobByApplicationId(int id);

	@Query("select j from Job j where j.deadline >= ?1 and j.finalMode = true")
	Collection<Job> findJobsActive(Date f);

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select c from Challenge2 c where c.job.id = ?1")
	Challenge2 findOneChallenge2ByJobId(int jobId);
}
