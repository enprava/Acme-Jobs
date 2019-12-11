
package acme.features.auditor.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id  = ?1")
	Job findOneJobById(int id);

	//	@Query("select j From j where j.id in (select a from AuditRecord where a.auditor.id = ?1)")
	@Query("select j from Job j")
	Collection<Job> findManyByAuditorId(int auditorId);

	//	@Query("select j From j where j.id not in (select a from AuditRecord where a.auditor.id = ?1)")
	@Query("select j from Job j")
	Collection<Job> findManyByNotAuditorId(int auditorId);

}
