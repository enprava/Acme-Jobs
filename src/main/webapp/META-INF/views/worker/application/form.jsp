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
	<acme:form-hidden path="hasChallenge"/>
	
	<acme:form-submit test= "${command== 'show' }"
		method="get" code="worker.application.form.label.jobs" action="/worker/job/show_mine?applicationId=${id}"/>
		
	<jstl:if test="${command == 'create' && hasShater == true}">
    	<acme:message code="worker.application.form.label.answer"/>
    	<acme:form-textarea code="worker.application.form.label.answerAnswer" path="answer"/>
    	<acme:form-textarea code="worker.application.form.label.answerPassword" path="password"/>
    	<acme:form-textarea code="worker.application.form.label.answerTrackId" path="trackId"/>
    </jstl:if>
    
    <acme:form-submit method="post" test= "${command== 'create' }"
		code="worker.application.form.button.create" action="/worker/application/create"/>
    
    <jstl:if test="${command != 'create' && hasAnswer == true}">
   		<acme:form-submit method="get" code="worker.application.form.button.answer" action="/worker/answer/show?applicationId=${id}"/>
    </jstl:if>	
	
	<acme:form-return code="worker.application.form.button.return"/>
</acme:form>
