
package acme.features.worker.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.entities.shaters.Shater;
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

	@Query("select s from Shater s where s.job.id= ?1")
	Shater findShaterByJobId(int jobId);
}
