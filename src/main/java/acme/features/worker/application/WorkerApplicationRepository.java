
package acme.features.worker.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.answers.Answer;
import acme.entities.applications.Application;
import acme.entities.duboas.Duboa;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerApplicationRepository extends AbstractRepository {

	@Query("select a from Application a Where a.id = ?1")
	Application findOneApplicationById(int id);

	@Query("select a from Application a where a.worker.id= ?1")
	Collection<Application> findManyByworkerId(int workerId);

	@Query("select j from Job j where j.id= ?1")
	Job findJobPublished(int jobId);

	@Query("select w from Worker w where w.id= ?1")
	Worker findWorkerById(int workerId);

	@Query("select c from Duboa c where c.job.id=?1")
	Duboa findDuboaByJobId(int jobId);

	@Query("select c.job from Application c where c.id=?1")
	Job findJobByApplicationId(int applicationId);

	@Query("select a from Answer a where a.application.id=?1")
	Answer findAnswerByApplicationId(int applicationId);

}
