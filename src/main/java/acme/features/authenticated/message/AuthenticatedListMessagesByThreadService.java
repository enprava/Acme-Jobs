
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messages.Message;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedListMessagesByThreadService implements AbstractListService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "tags", "body");

	}

	//	public Collection<Message> findManyMessagesByThread(final Request<Message> request) {
	//
	//		Collection<Message> result;
	//
	//		result = this.repository.findManyMessagesByThread(request.getModel().getInteger("threadId"));
	//
	//		return result;
	//	}

	@Override
	public Collection<Message> findMany(final Request<Message> request) {

		Collection<Message> result;

		result = this.repository.findManyMessagesByThread(request.getModel().getInteger("threadId"));

		return result;

	}

	//	@Override
	//	public Collection<Message> findMany(final Request<Message> request) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

}
