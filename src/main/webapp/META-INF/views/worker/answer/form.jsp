<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">

	<acme:form-textbox code="employer.answer.form.label.answer" path="answer"/>
	<acme:form-password code="employer.answer.form.label.password" path="password"/>
	<acme:form-url code="employer.answer.form.label.trackId" path="trackId"/>
	
	
	<acme:form-return code="employer.answer.form.button.return"/>

</acme:form>