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
	<acme:form-textbox code="employer.application.form.label.reference-number" path="referenceNumber" readonly="true"/>
	<acme:form-textbox code="employer.application.form.label.creation-moment" path="creationMoment" readonly="true"/>
	<acme:form-textarea  code="employer.application.form.label.statement" path="statement" readonly="true"/>
	<acme:form-textarea  code="employer.application.form.label.skills" path="skills" readonly="true"/>
	<acme:form-textbox  code="employer.application.form.label.qualifications" path="qualifications" readonly="true"/>
	
	

	<jstl:if test="${command != 'create' && hasAnswer == true}">
	<acme:form-textbox  code="employer.application.form.label.answerPasswordApp" path="answerPasswordApp" readonly="true"/>
    <acme:form-submit method="get" code="employer.application.form.button.answer" action="/employer/answer/show?appId=${id}"/>
    </jstl:if>
	
	<jstl:if test="${status == 'pending' && command == 'show'}">
    <acme:form-select code="employer.application.form.label.status" path="status">
    <acme:form-option code="employer.application.form.label.status.pending" value="pending"/>
    <acme:form-option code="employer.application.form.label.status.accepted" value="accepted"/>
    <acme:form-option code="employer.application.form.label.status.rejected" value="rejected"/>
    </acme:form-select>
    </jstl:if>

    <jstl:if test="${status == 'pending' && command == 'update'}">
    <acme:form-select code="employer.application.form.label.status" path="status">
    <acme:form-option code="employer.application.form.label.status.pending" value="pending"/>
    <acme:form-option code="employer.application.form.label.status.rejected" value="rejected"/>
    <acme:form-option code="employer.application.form.label.status.accepted" value="accepted"/>
    </acme:form-select>
    </jstl:if>
<jstl:if test="${status == 'accepted' && command == 'update'}">
    <acme:form-select code="employer.application.form.label.status" path="status">
    <acme:form-option code="employer.application.form.label.status.accepted" value="accepted"/>
    <acme:form-option code="employer.application.form.label.status.rejected" value="rejected"/>
    <acme:form-option code="employer.application.form.label.status.pending" value="pending"/>
    </acme:form-select>
    </jstl:if>

    <jstl:if test="${status == 'rejected' && command == 'update'}">
    <acme:form-select code="employer.application.form.label.status" path="status">
    <acme:form-option code="employer.application.form.label.status.rejected" value="rejected"/>
    <acme:form-option code="employer.application.form.label.status.pending" value="pending"/>
    <acme:form-option code="employer.application.form.label.status.accepted" value="accepted"/>
    </acme:form-select>
    </jstl:if>

    <jstl:if test="${status != 'pending' && command == 'show'}">
        <acme:form-textarea code="employer.application.form.label.status" path="status" readonly="true"/>
    </jstl:if>
    <acme:form-textarea code="employer.application.form.label.justification" path="justification"/>


    <acme:form-submit test ="${command == 'show' && status == 'pending'}" code="employer.application.form.button.update" action="/employer/application/update"/>
    <acme:form-submit test ="${command == 'update'}" code="employer.application.form.button.update" action="/employer/application/update"/>
    <acme:form-return code="employer.application.form.button.return"/>
	
	
	
	
	
</acme:form>
