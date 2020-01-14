
package acme.features.worker.answer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.answers.Answer;
import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerAnswerRepository extends AbstractRepository {

	@Query("select a from Answer a where a.application.id = ?1")
	Answer findAnswerByApplicationId(int applicationId);

	@Query("select a from Application a Where a.id = ?1")
	Application findOneApplicationById(int id);

}
