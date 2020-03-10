<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp"/>
	<img/>
	<div>
		<span>${park.parkName}</span>
		<span>${park.description}</span>
	</div>
	<div>
		<span>${park.inspirationalQuote}</span>
		<span>${park.inspQuoteSource}</span>
	</div>
	<table>
	</table>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>