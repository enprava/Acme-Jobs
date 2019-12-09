<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.company-records.list.label.name" path="name" />
	<acme:form-textbox code="administrator.company-records.list.label.sector" path="sector" />
	<acme:form-textbox code="administrator.company-records.list.label.ceoname" path="ceoname" />
	<acme:form-textarea code="administrator.company-records.list.label.description" path="description" />
	<acme:form-url code="administrator.company-records.list.label.web" path="web" />
	<acme:form-textbox code="administrator.company-records.list.label.phone" path="phone" />
	<acme:form-textbox code="administrator.company-records.list.label.email" path="email" />
	<acme:form-textbox code="administrator.company-records.list.label.stars" path="stars" />
	<acme:form-checkbox code="administrator.company-records.list.label.incorporated" path="incorporated" />

	<acme:form-submit test="${command == 'show'}" code="administrator.company-records.form.button.update"
		action="/administrator/company-record/update" />
	<acme:form-submit test="${command == 'show'}" code="administrator.company-records.form.button.delete"
		action="/administrator/company-record/delete" />
	<acme:form-submit test="${command == 'create'}" code="administrator.company-records.form.button.create"
		action="/administrator/company-record/create" />
	<acme:form-submit test="${command == 'update'}" code="administrator.company-records.form.button.update"
		action="/administrator/company-record/update" />
	<acme:form-submit test="${command == 'delete'}" code="administrator.company-records.form.button.delete"
		action="/administrator/company-record/delete" />
	<acme:form-return code="administrator.company-records.form.button.return" />
</acme:form>