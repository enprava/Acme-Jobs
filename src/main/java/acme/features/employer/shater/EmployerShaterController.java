
package acme.features.employer.shater;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Employer;
import acme.entities.shaters.Shater;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/shater/")
public class EmployerShaterController extends AbstractController<Employer, Shater> {

	@Autowired
	private EmployerShaterShowService showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
