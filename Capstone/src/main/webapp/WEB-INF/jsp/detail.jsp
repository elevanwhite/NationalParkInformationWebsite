<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<img class="detailImg" src="img/parks/${park.imageName}"/>
<br>
<div class="detailDesc">
	<h1>${park.parkName}</h1> 
	<br>
	<span>${park.description}</span>
	<br>
</div>
<table class="parkStats">
	<tr>
		<th>State</th> 
		<th>Climate</th>
		<th>Acreage</th> 	
		<th>Elevation</th> 
		<th>Species</th>
	</tr>
	<tr>
		<td>${park.state}</td>
		<td>${park.climate}</td>
		<td>${park.acreage}</td>
		<td>${park.elevationInFeet}</td>
		<td>${park.numberOfAnimalSpecies}</td>
	</tr>
</table>
<div class="detailDesc">
	<span>${park.parkName} features ${park.milesOfTrail} miles of
		trail and boasts ${park.numberOfCampsites} unique camp sites. It was
		founded in ${park.yearFounded} and received ${park.annualVisitors}
		visitors in the previous year. Come visit this amazing park for only
		$${park.entryFee}. </span>
		<br>
</div>
<div class="detailDesc">
	<span>"${park.inspirationalQuote}"</span>
	<br>
	<span>- ${park.inspQuoteSource}</span>
</div>
<c:set value="${weathers.get(0)}" var="today"/>
	<div class="weatherHeader">
		<h2>Five Day Forecast:</h2>
		<span>${month} ${day}</span>
	</div>
<div id="todayWeather">
	<img src="img/weather/${today.imageName}"/>
	<div>
		<h3>High: ${today.highTemp} 
			<c:if test="${celsius == 't'}"> °C</c:if><c:if test="${celsius != 't'}"> °F</c:if>
		</h3>
		<h3>Low: ${today.lowTemp}
			<c:if test="${celsius == 't'}"> °C</c:if><c:if test="${celsius != 't'}"> °F</c:if>
		</h3>
	</div>
	
	<c:if test="${not empty today.getRecommendation()}">
	<div>
		<h5>Recommendation(s):</h5> 
		<span>${today.getRecommendation()}</span>
	</div>
	</c:if>
</div>
<hr>
<div class="weatherDiv">
<c:forEach var="weather" items="${weathers}">
	<c:if test="${weather.fiveDayForecastValue >1}">
		<div>
			<span>${month} ${day + weather.fiveDayForecastValue - 1}</span>
			<img src="img/weather/${weather.imageName}"/>
			<span>High: ${weather.highTemp}<c:if test="${celsius == 't'}"> °C</c:if><c:if test="${celsius != 't'}"> °F</c:if></span>
			<span>Low: ${weather.lowTemp}<c:if test="${celsius == 't'}"> °C</c:if><c:if test="${celsius != 't'}"> °F</c:if></span>
			<br>
		</div>
	</c:if>
</c:forEach>
</div>
<c:url value="/detail" var="detailURL"/> 
<form action="${detailURL}" method="GET">
	<input type="hidden" name="code" value="${park.parkCode}">
	<c:choose>
		<c:when test="${empty celsius or celsius == 'f'}">
			<input type="hidden" name="celsius" value="t">
			<button class="btn btn-outline-primary" type="submit">Convert to °C</button>
		</c:when>
		<c:otherwise>
			<input type="hidden" name="celsius" value="f">
			<button class="btn btn-outline-primary" type="submit">Convert to °F</button>
		</c:otherwise>
	</c:choose>
</form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />

