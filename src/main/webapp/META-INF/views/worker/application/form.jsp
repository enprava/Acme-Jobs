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

<acme:form>
	
	<jstl:if test="${command != 'create'}">
		<acme:form-textarea code="worker.application.form.label.status" path="status" readonly="true"/>
		<acme:form-moment code="worker.application.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	<acme:form-textbox code="worker.application.form.label.reference-number" path="referenceNumber" placeholder="EEEE-JJJJ:WWWW"/>
	<acme:form-textarea code="worker.application.form.label.statement" path="statement"/>
	<acme:form-textarea code="worker.application.form.label.skills" path="skills"/>
	<acme:form-textbox code="worker.application.form.label.qualifications" path="qualifications"/>
	<acme:form-hidden path="jobId"/>
	<acme:form-hidden path="hasDuboa"/>
	<acme:form-hidden path="hasAnswer"/>
	
	<jstl:if test="${command == 'create' && hasDuboa==true }"> 
    
    <acme:form-textarea code="worker.application.label.form.answer.answer" path="answer"/>
    <acme:form-password code="worker.application.label.form.answer.password" path="password"/>
    <acme:form-url code="worker.application.label.form.answer.trackId" path="trackId"/>
    </jstl:if> 

	
    
	<acme:form-submit test= "${command== 'show' }"
		method="get" code="worker.application.form.label.jobs" action="/worker/job/show_mine?applicationId=${id}"/>
		
		<acme:form-submit test= "${command== 'show' && hasAnswer }"
		method="get" code="worker.application.form.label.answer" action="/worker/answer/show?applicationId=${id}"/>
	
	<acme:form-submit test= "${command== 'create' }"
		code="worker.application.form.button.create" action="/worker/application/create"/>
		
		
	
	<acme:form-return code="authenticated.challenge.form.button.return"/>
</acme:form>
