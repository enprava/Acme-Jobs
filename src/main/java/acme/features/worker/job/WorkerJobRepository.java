
package acme.features.worker.job;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerJobRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = ?1")
	Application findOneJobByApplicationId(int id);

}
