
package acme.features.provider.request;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests.Request;
import acme.entities.roles.Provider;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;

@Service
public class ProviderRequestCreateService implements AbstractCreateService<Provider, Request> {

	@Autowired
	ProviderRequestRepository repository;


	@Override
	public boolean authorise(final acme.framework.components.Request<Request> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");

	}

	@Override
	public void unbind(final acme.framework.components.Request<Request> request, final Request entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		if (request.isMethod(HttpMethod.GET)) {

			model.setAttribute("accept", "false");
		} else {
			request.transfer(model, "accept");
		}

		request.unbind(entity, model, "title", "text", "deadline", "reward", "ticker");

	}

	@Override
	public Request instantiate(final acme.framework.components.Request<Request> request) {
		Request result;

		result = new Request();
		return result;
	}

	@Override
	public void validate(final acme.framework.components.Request<Request> request, final Request entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Boolean isAccepted;
		Calendar calendar;
		Date minimumDeadline;
		Request existing;

		if (!errors.hasErrors("deadline")) {
			calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			minimumDeadline = calendar.getTime();
			errors.state(request, entity.getDeadline().after(minimumDeadline), "deadline", "provider.request.deadline.error");
		}

		if (!errors.hasErrors("ticker")) {
			existing = this.repository.findOneRequestByTicker(entity.getTicker());
			errors.state(request, existing == null, "ticker", "provider.request.ticker.error");
		}

		if (!errors.hasErrors("reward")) {
			Money rew = entity.getReward();
			errors.state(request, rew.getCurrency().contentEquals("EUR") || rew.getCurrency().contentEquals("€"), "reward", "provider.request.reward.currency.error");
		}

		isAccepted = request.getModel().getBoolean("accept");
		errors.state(request, isAccepted, "accept", "provider.request.error.accept");
	}

	@Override
	public void create(final acme.framework.components.Request<Request> request, final Request entity) {
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
