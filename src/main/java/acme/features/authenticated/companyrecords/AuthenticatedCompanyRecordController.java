
package acme.features.authenticated.companyrecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.companyrecords.CompanyRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/company-record/")
public class AuthenticatedCompanyRecordController extends AbstractController<Authenticated, CompanyRecord> {

	@Autowired
	private AuthenticatedCompanyRecordListService	listservice;
	@Autowired
	private AuthenticatedCompanyRecordShowService	showservice;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listservice);
		super.addBasicCommand(BasicCommand.SHOW, this.showservice);
	}

}
