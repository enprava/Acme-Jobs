
package acme.features.administrator.companyrecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.companyrecords.CompanyRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@RequestMapping("/administrator/company-record/")
@Controller
public class AdministratorCompanyRecordController extends AbstractController<Administrator, CompanyRecord> {

	@Autowired
	AdministratorCompanyRecordUpdateService	updateService;

	@Autowired
	AdministratorCompanyRecordCreateService	createService;

	@Autowired
	AdministratorCompanyRecordDeleteService	deleteService;

	@Autowired
	AdministratorCompanyRecordListService	listService;

	@Autowired
	AdministratorCompanyRecordShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
