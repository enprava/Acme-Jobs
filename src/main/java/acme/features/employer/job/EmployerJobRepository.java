
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.duties.Duty;
import acme.entities.jobs.Job;
import acme.entities.parameters.Parameter;
import acme.entities.roles.Employer;
import acme.entities.shaters.Shater;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select j from Job j where j.employer.id = ?1")
	Collection<Job> findManyByEmployerId(int employerId);

	@Query("select e from Employer e where e.userAccount.id = ?1")
	Employer findEmployerByUserAccountId(int id);

	@Query("select sum(d.percentage) from Duty d where d.job.id = ?1")
	Double sumDutiesPercentageByJobId(int jobId);

	@Query("select a from Application a where a.job.id = ?1")
	Collection<Application> applicationsByJobId(int jobId);

	@Query("select d from Duty d where d.job.id = ?1")
	Collection<Duty> findManyDutiesByJobId(int jobId);

	@Query("select p from Parameter p")
	Parameter findParameters();

	@Query("select j from Job j")
	Collection<Job> findAllJobs();

	@Query("select s from Shater s where s.job.id= ?1")
	Shater findShaterByJobId(int jobId);

}
