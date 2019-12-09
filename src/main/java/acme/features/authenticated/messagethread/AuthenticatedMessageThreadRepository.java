
package acme.features.authenticated.messagethread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messagethreads.MessageThread;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageThreadRepository extends AbstractRepository {

	@Query("select m from MessageThread m where m.id = ?1")
	MessageThread findOneById(int id);

	@Query("select m , count(r) from MessageThread m join m.useraccount r where r.id = ?1 group by m")
	Collection<MessageThread> findMany(int id);

}
