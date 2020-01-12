<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
    <acme:form-textbox code="worker.answer.form.label.answer" path="answer" />
    <acme:form-textarea code="worker.answer.form.label.password" path="password" />
    <acme:form-textarea code="worker.answer.form.label.trackId" path="trackId" />
    
    <acme:form-return code="worker.answer.form.button.return" />
</acme:form>