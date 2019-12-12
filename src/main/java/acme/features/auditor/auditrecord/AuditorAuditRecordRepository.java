
package acme.features.auditor.auditrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditrecords.Auditrecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditRecordRepository extends AbstractRepository {

	@Query("select a from Auditrecord a where a.id = ?1")
	Auditrecord findOneAuditRecordById(int id);

	@Query("select a from Auditrecord a where a.job.id = ?1")
	Collection<Auditrecord> findManyAuditRecordByJobId(int jobId);
}
