
package acme.features.authenticated.messagethread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.messagethreads.MessageThread;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.UserAccount;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageThreadShowService implements AbstractShowService<Authenticated, MessageThread> {

	@Autowired
	AuthenticatedMessageThreadRepository repository;


	@Override
	public boolean authorise(final Request<MessageThread> request) {

		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<MessageThread> request, final MessageThread entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "users");

	}

	@Override
	public MessageThread findOne(final Request<MessageThread> request) {

		assert request != null;

		String users = "";
		MessageThread result;
		int id, i = 0;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		for (UserAccount ua : result.getUseraccount()) {

			if (i == 0) {
				users = ua.getUsername();
			} else {
				users = users + ", " + ua.getUsername();
			}
			i++;
		}

		result.setUsers(users);

		return result;
	}

}
