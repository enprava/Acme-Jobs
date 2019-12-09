
package acme.features.administrator.parameter;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.parameters.Parameter;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorParameterRepository extends AbstractRepository {

	@Query("select s from Parameter s")
	Collection<Parameter> findManyAll();

}
