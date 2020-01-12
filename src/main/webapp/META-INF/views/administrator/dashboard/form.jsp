<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
    
    <acme:form-double code="administrator.dashboard.form.label.jobsWithShater" path="jobsWithShater"/>
    <acme:form-double code="administrator.dashboard.form.label.shaterWithTrackId" path="shaterWithTrackId"/>
    <acme:form-double code="administrator.dashboard.form.label.applicationsProtected" path="applicationsProtected"/>
    
    <acme:form-return code="administrator.dashboard.form.button.return"/>
</acme:form>