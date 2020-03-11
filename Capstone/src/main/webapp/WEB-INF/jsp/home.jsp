<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<c:forEach items="${parks}" var="park">
	<div class="parkOverview">
	<div class="col-4">
		<a href="<c:url value="/detail?code=${park.parkCode}"/>"><img class="parkImg" src="img/parks/${park.imageName}"/></a>
		</div>
		<div class="col-8">
			<h3>${park.parkName}</h3>
			<span>${park.description}</span>
			
		</div>
	</div>
</c:forEach>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>