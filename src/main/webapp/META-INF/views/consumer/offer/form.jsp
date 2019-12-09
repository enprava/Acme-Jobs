<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="authenticated.offer.form.label.title" path="title"/>
	
	<jstl:if test="${command != 'create' }">
	<acme:form-moment 
	code="authenticated.offer.form.label.moment" 
	path="moment"
	readonly="true"/>
	
	
	</jstl:if>
	
	<acme:form-moment code="authenticated.offer.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="authenticated.offer.form.label.text" path="text"/>
	<acme:form-money code="authenticated.offer.form.label.minmoney" path="minmoney"/>
	<acme:form-money code="authenticated.offer.form.label.maxmoney" path="maxmoney"/>
	<acme:form-textbox code="authenticated.offer.form.label.ticker" path="ticker" placeholder="OXXXX-99999"/>
	
	<acme:form-checkbox code="consumer.offer.accept" path="accept"/>
	
	<acme:form-submit test="${command == 'show' }"
	code="consumer.offer.form.button.update" 
	action="/consumer/offer/update"/>
	
	<acme:form-submit test="${command == 'show' }"
	code="consumer.offer.form.button.delete" 
	action="/consumer/offer/delete"/>
	
	<acme:form-submit test="${command == 'create' }"
	code="consumer.offer.form.button.create" 
	action="/consumer/offer/create"/>
	
	<acme:form-submit test="${command == 'update' }"
	code="consumer.offer.form.button.update" 
	action="/consumer/offer/update"/>
	
	<acme:form-submit test="${command == 'delete' }"
	code="consumer.offer.form.button.delete" 
	action="/consumer/offer/delete"/>


	<acme:form-return code="authenticated.offer.form.button.return"/>

</acme:form>