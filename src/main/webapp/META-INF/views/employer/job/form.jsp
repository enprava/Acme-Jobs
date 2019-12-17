<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
    <acme:form-textbox code="employer.job.form.label.reference" path="reference" />
    <acme:form-textbox code="employer.job.form.label.title" path="title" />
    <acme:form-moment code="employer.job.form.label.deadline" path="deadline" />
    <acme:form-money code="employer.job.form.label.salary" path="salary" />
    <acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo" />
    <acme:form-textarea code="employer.job.form.label.description" path="description" />
    
    <jstl:if test="${command != 'create'}">
    <acme:form-select code="employer.job.form.label.finalMode" path="finalMode">
    	<acme:form-option code="employer.job.form.label.false" value="false"/>
    	<acme:form-option code="employer.job.form.label.true" value="true"/>
    </acme:form-select>
    </jstl:if>
    
    <jstl:if test="${command != 'create'}">
    <acme:form-submit method="get" code="employer.job.form.label.duties" action="/employer/duty/list-for-job?jobId=${id}"/>
    </jstl:if>
    
    <acme:form-submit test="${command == 'show'}"
  		code="employer.job.form.button.update"
  		action="/employer/job/update"/>
  		
  	<acme:form-submit test="${command == 'show'}"
  		code="employer.job.form.button.delete"
  		action="/employer/job/delete"/>
  		
  	<acme:form-submit method="post" test="${command == 'create'}"
  		code="employer.job.form.button.create"
  		action="/employer/job/create"/>
  		
  	<acme:form-submit test="${command == 'update'}"
  		code="employer.job.form.button.update"
  		action="/employer/job/update"/>
  		
  	<acme:form-submit test="${command == 'delete'}"
  		code="employer.job.form.button.delete"
  		action="/employer/job/delete"/>
  		
    <acme:form-return code="employer.job.form.button.return" />
</acme:form>