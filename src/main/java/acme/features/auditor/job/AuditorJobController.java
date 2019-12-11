
package acme.features.auditor.job;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/auditor/job/")
public class AuditorJobController extends AbstractController<Auditor, Job> {

	@Autowired
	private AuditorJobShowService			showservice;
	@Autowired
	private AuditorJobListMineService		listMineservice;
	@Autowired
	private AuditorJobListNotMineService	listNotMineservice;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showservice);
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineservice);
		super.addCustomCommand(CustomCommand.LIST_NOT_MINE, BasicCommand.LIST, this.listNotMineservice);
	}
}
