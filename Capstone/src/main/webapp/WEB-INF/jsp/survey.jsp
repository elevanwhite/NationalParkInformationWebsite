<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url value="/survey" var="submitSurveyUrl"/>
<form:form action="${submitSurveyUrl}" method="POST" modelAttribute="surveyData">
	<div>
		<label for="favPark">Favorite National Park</label>
		<form:select id="favPark" name="favPark" required="required" path="favPark">
			<c:forEach items="${parks}" var="park">
				<option value="${park.parkCode}">${park.parkName}</option>
			</c:forEach>
		</form:select>
		<form:errors path="validPark"/>
		
	</div>
	<div>
		<label for="email">Your Email</label>
		<form:input type="email" id="email" name="email" required="required" placeholder="email address" path="email"/>
		<form:errors path="email"/>
	</div>
	<div>	
		<label for="stateRes">State of Residence</label>
		<form:select id="stateRes" name="stateRes" required="required" path="stateRes">
		<c:forEach items="${states}" var="state">
				<option>${state}</option>
			</c:forEach>
		</form:select>
		<form:errors path="validState"/>
		
	</div>
	<div>
		<form:radiobutton id="inactive" name="activityLvl" value="inactive" path="activityLvl"/>
		<label for="inactive">Inactive</label>
		<form:radiobutton id="sedentary" name="activityLvl" value="sedentary" path="activityLvl"/>
		<label for="sedentary">Sedentary</label>
		<form:radiobutton id="active" name="activityLvl" value="active" path="activityLvl"/>
		<label for="active">Active</label>
		<form:radiobutton id="extremelyActive" name="activityLvl" value="extremelyActive" path="activityLvl"/>
		<label for="extremelyActive">Extremely Active</label>
		<form:errors path="validActivityLevel"/>
	</div>
	<button type="submit">Submit</button>
</form:form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />