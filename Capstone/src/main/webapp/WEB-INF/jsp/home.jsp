<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>

<c:forEach items="${parks}" var="park">
	<div>
		<a href="<c:url value="/detail?code=${park.parkCode}"/>"><img src="img/parks/${park.imageName}"/></a>
		<div>
			<span>${park.parkName}</span>
			<span>${park.description}</span>
		</div>
	</div>
</c:forEach>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>