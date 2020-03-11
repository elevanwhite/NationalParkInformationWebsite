<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<img />
<div>
	<span>${park.parkName}</span> 
	<br>
	<span>${park.description}</span>
	<br>
</div>
<div>
	<span>State: ${park.state}</span> 
	<br> 
	<span>Climate: ${park.climate}</span> 
	<br> 
	<span>Acreage: ${park.acreage}</span> 
	<br>
	<span>Elevation: ${park.elevationInFeet}</span> 
	<br> 
	<span># of Animal Species: ${park.numberOfAnimalSpecies}</span>
</div>
<div>
	<span>${park.parkName} features ${park.milesOfTrail} miles of
		trail and boasts ${park.numberOfCampsites} unique camp sites. It was
		founded in ${park.yearFounded} and received ${park.annualVisitors}
		visitors in the previous year. Come visit this amazing park for only
		$${park.entryFee}. </span>
		<br>
</div>
<div>
	<span>${park.inspirationalQuote}</span>
	<br>
	<span>${park.inspQuoteSource}</span>
</div>
<div>
<c:set value="${weathers.get(0)}" var="today"/>
	<span>Today's Forecast: </span>
	<img src="img/weather/${today.imageName}"/>
	<span>High: ${today.highTemp}</span>
	<span>Low: ${today.lowTemp}</span>
	<c:if test="${today.getRecommendation().equals('')==false }">
	<span>Recommendation(s): ${today.getRecommendation()}</span>
	</c:if>
<br>
</div>
<c:forEach var="weather" items="${weathers}">
	<c:if test="${weather.fiveDayForecastValue >1}">
		<div>
			<img src="img/weather/${weather.imageName}"/>
			<span>High: ${weather.highTemp}</span>
			<span>Low: ${weather.lowTemp}</span>
			<br>
		</div>
	</c:if>
</c:forEach>
<c:url value="/detail" var="detailURL"/> 
<form action="${detailURL}" method="GET">
<input type="hidden" name="code" value="${park.parkCode}">
<c:choose>
<c:when test="${empty celsius or celsius == 'f'}">
<input type="hidden" name="celsius" value="t">
<button type="submit">Convert to Celsius</button>
</c:when>
<c:otherwise>
<input type="hidden" name="celsius" value="f">
<button type="submit">Convert to Fahrenheit</button>
</c:otherwise>
</c:choose>
</form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />