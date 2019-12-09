<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.company-records.list.label.name" path="name" width="70%" />
	<acme:list-column code="administrator.company-records.list.label.sector" path="sector" width="30%" />
</acme:list>