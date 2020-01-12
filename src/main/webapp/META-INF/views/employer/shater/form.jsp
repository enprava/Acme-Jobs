<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
    <acme:form-textbox code="employer.shater.form.label.trackId" path="trackId" />
    <acme:form-textarea code="employer.shater.form.label.description" path="description" />
    
    <acme:form-return code="employer.shater.form.button.return" />
</acme:form>