<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="anonymous.company-records.list.label.name" path="name" />
	<acme:form-textbox code="anonymous.company-records.list.label.sector" path="sector" />
	<acme:form-textbox code="anonymous.company-records.list.label.ceoname" path="ceoname" />
	<acme:form-textarea code="anonymous.company-records.list.label.description" path="description" />
	<acme:form-textbox code="anonymous.company-records.list.label.web" path="web" />
	<acme:form-textbox code="anonymous.company-records.list.label.phone" path="phone" />
	<acme:form-textbox code="anonymous.company-records.list.label.email" path="email"/>
	<acme:form-textbox code="anonymous.company-records.list.label.stars" path="stars" />
	<acme:form-checkbox code="anonymous.company-records.list.label.incorporated" path="incorporated" />
	
	<acme:form-return code="anonymous.company-records.button.return"/>
</acme:form>