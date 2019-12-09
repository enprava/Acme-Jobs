<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	
	<acme:form-textbox code="worker.application.form.label.reference-number" path="referenceNumber"/>
	<acme:form-textarea code="worker.application.form.label.status" path="status"/>
	<acme:form-textarea code="worker.application.form.label.statement" path="statement"/>
	<acme:form-textarea code="worker.application.form.label.skills" path="skills"/>
	<acme:form-textbox code="worker.application.form.label.qualifications" path="qualifications"/>
	
	<acme:form-submit method="get" code="worker.application.form.label.jobs" action="/worker/job/show?applicationId=${id}"/>
	<acme:form-return code="authenticated.challenge.form.button.return"/>
</acme:form>
