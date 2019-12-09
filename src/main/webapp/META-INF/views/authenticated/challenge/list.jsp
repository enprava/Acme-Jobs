<%@page language="java"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.challenge.list.label.title" path="title" width="40%"/>
	<acme:list-column code="authenticated.challenge.list.label.deadline" path="deadline" width="30%"/>
	<acme:list-column code="authenticated.challenge.list.label.reward-bronze" path="rewardBronze" width="10%"/>
	<acme:list-column code="authenticated.challenge.list.label.reward-silver" path="rewardSilver" width="10%"/>
	<acme:list-column code="authenticated.challenge.list.label.reward-gold" path="rewardGold" width="10%"/>
</acme:list>