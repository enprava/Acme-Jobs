<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	
	<acme:list-column code="employer.application.list.label.creation-moment" path="creationMoment" width="50%"/>
	<acme:list-column code="employer.application.list.label.status" path="status" width="50%"/>

</acme:list>