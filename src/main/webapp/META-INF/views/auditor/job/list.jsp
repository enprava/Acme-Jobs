<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="auditor.job.list.label.reference" path="reference"witdh="10%"/>
	<acme:list-column code="auditor.job.list.label.deadline" path="deadline"witdh="10%"/>
	<acme:list-column code="auditor.job.list.label.title" path="reference"witdh="80%"/>
	
</acme:list>