
package acme.features.consumer.offer;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.entities.roles.Consumer;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractCreateService;

@Service
public class ConsumerOfferCreateService implements AbstractCreateService<Consumer, Offer> {

	@Autowired
	ConsumerOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment");
	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "text", "deadline", "minmoney", "maxmoney", "ticker");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("password", "");
			model.setAttribute("confirmation", "");
			model.setAttribute("accept", "false");
		} else {
			request.transfer(model, "password", "confirmation", "accept");
		}
	}

	@Override
	public Offer instantiate(final Request<Offer> request) {
		Offer result;
		result = new Offer();

		return result;
	}

	@Override
	public void validate(final Request<Offer> request, final Offer entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean isAccepted;
		Calendar calendar;
		Date minimumDeadline;
		Offer existing;

		isAccepted = request.getModel().getBoolean("accept");
		errors.state(request, isAccepted, "accept", "anonymous.user-account.error.must-accept");

		if (!errors.hasErrors("deadline")) {
			calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			minimumDeadline = calendar.getTime();
			errors.state(request, entity.getDeadline().after(minimumDeadline), "deadline", "consumer.offer.deadline.error");
		}

		if (!errors.hasErrors("ticker")) {
			existing = this.repository.findOneOfferByTicker(entity.getTicker());
			errors.state(request, existing == null, "ticker", "consumer.offer.ticker.error");
		}

		if (!errors.hasErrors("minmoney")) {
			Money min = entity.getMinmoney();
			errors.state(request, min.getCurrency().contentEquals("EUR") || min.getCurrency().contentEquals("€"), "minmoney", "consumer.offer.minmoney.currency.error");
		}

		if (!errors.hasErrors("maxmoney")) {
			Money max = entity.getMaxmoney();
			errors.state(request, max.getCurrency().contentEquals("EUR") || max.getCurrency().contentEquals("€"), "maxmoney", "consumer.offer.maxmoney.currency.error");
		}

		if (!errors.hasErrors("minmoney") || !errors.hasErrors("maxmoney")) {
			Money min = entity.getMinmoney();
			Money max = entity.getMaxmoney();
			errors.state(request, max.getAmount() >= min.getAmount(), "minmoney", "consumer.offer.rangemoney.error");
		}

		//		if (!errors.hasErrors("minmoney")) {
		//			Money min = entity.getMinmoney();
		//			errors.state(request, min.getAmount() >= 0, "minmoney", "consumer.offer.minmoney.positive");
		//		}
		//
		//		if (!errors.hasErrors("maxmoney")) {
		//			Money max = entity.getMaxmoney();
		//			errors.state(request, max.getAmount() >= 0, "maxmoney", "consumer.offer.maxmoney.positive");
		//		}

	}

	@Override
	public void create(final Request<Offer> request, final Offer entity) {

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

}
