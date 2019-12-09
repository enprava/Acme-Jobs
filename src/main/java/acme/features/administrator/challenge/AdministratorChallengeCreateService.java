
package acme.features.administrator.challenge;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

	@Autowired
	private AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "goalBronze", "rewardBronze", "goalSilver", "rewardSilver", "goalGold", "rewardGold");
	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		assert request != null;

		Challenge result;

		//		Date deadline = new Date(System.currentTimeMillis() + 10000);

		//		Money dineroBronce = new Money();
		//		dineroBronce.setAmount(12.);
		//		dineroBronce.setCurrency("€");
		//		Money dineroPlata = new Money();
		//		dineroPlata.setAmount(24.);
		//		dineroPlata.setCurrency("€");
		//		Money dineroOro = new Money();
		//		dineroOro.setAmount(48.);
		//		dineroOro.setCurrency("€");

		result = new Challenge();
		//		result.setTitle("título de ejemplo");
		//		result.setDeadline(deadline);
		//		result.setDescription("lorem ipsum");
		//		result.setLevel(TipoGoal.BRONZE);
		//		result.setGoalBronze("Bronze goal");
		//		result.setRewardBronze(dineroBronce);
		//		result.setGoalSilver("Silver goal");
		//		result.setRewardSilver(dineroPlata);
		//		result.setGoalGold("Gold goal");
		//		result.setRewardGold(dineroOro);

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		boolean isValidB, isValidS, isValidG;
		Calendar calendar;
		Date minimumDeadline;
		isValidB = false;
		isValidS = false;
		isValidG = false;

		if (!errors.hasErrors("rewardBronze")) {
			isValidB = entity.getRewardBronze().getCurrency().contentEquals("€") || entity.getRewardBronze().getCurrency().contentEquals("EUR");
			errors.state(request, isValidB, "rewardBronze", "administrator.challenge.form.error.invalidmoney");

		}
		if (!errors.hasErrors("rewardSilver")) {
			isValidS = entity.getRewardSilver().getCurrency().contentEquals("€") || entity.getRewardSilver().getCurrency().contentEquals("EUR");
			errors.state(request, isValidS, "rewardSilver", "administrator.challenge.form.error.invalidmoney");

		}
		if (!errors.hasErrors("rewardGold")) {
			isValidG = entity.getRewardGold().getCurrency().contentEquals("€") || entity.getRewardGold().getCurrency().contentEquals("EUR");
			errors.state(request, isValidG, "rewardGold", "administrator.challenge.form.error.invalidmoney");

		}
		if (isValidB && isValidS) {
			if (!errors.hasErrors("rewardBronze") && !errors.hasErrors("rewardSilver")) {
				errors.state(request, entity.getRewardBronze().getAmount() < entity.getRewardSilver().getAmount(), "rewardSilver", "administrator.challenge.form.error.invalidreward");
			}
		}
		if (isValidS && isValidG) {
			if (!errors.hasErrors("rewardSilver") && !errors.hasErrors("rewardGold")) {
				errors.state(request, entity.getRewardSilver().getAmount() < entity.getRewardGold().getAmount(), "rewardGold", "administrator.challenge.form.error.invalidreward");
			}
		}
		if (!errors.hasErrors("deadline")) {
			calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			minimumDeadline = calendar.getTime();
			errors.state(request, entity.getDeadline().after(minimumDeadline), "deadline", "administrator.challenge.form.error.invaliddeadline");
		}

	}

	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
