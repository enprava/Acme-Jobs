
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.message-thread.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.message-thread.form.label.moment" path="moment"/>
	<acme:form-textbox code="authenticated.message-thread.form.label.users" path="users"/>
	
  	<acme:form-return code="authenticated.message-thread.form.label.return"/>
 
 	<acme:form-submit method="get" code="authenticated.message-thread.form.button.messages" action="/authenticated/message/list-messages-by-thread?threadId=${id}"/>
 
 	
  	
</acme:form>
