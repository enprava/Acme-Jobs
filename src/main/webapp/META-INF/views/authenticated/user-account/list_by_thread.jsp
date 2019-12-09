<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
		
		<acme:list-column code="authenticated.user-account.list_by_thread.label.username" path="username" width="100%"/>

</acme:list>
