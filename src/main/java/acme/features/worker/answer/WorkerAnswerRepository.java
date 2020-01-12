
package acme.features.worker.answer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.answer.Answer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerAnswerRepository extends AbstractRepository {

	@Query("select a from Answer a where a.application.id= ?1")
	Answer findApplicationByApplicationId(int applicationId);

}
