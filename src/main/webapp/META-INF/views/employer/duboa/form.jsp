<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">

	<acme:form-textbox code="employer.duboa.form.label.text" path="text" />
	<acme:form-url code="employer.duboa.form.label.trackId" path="trackId" />


	<acme:form-return code="employer.duboa.form.button.return" />

</acme:form>