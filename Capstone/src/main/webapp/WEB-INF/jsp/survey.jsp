<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url value="/survey" var="submitSurveyUrl"/>
<form:form action="${submitSurveyUrl}" method="POST" modelAttribute="surveyData">
	<div class="form-group">
		<label for="favPark">Favorite National Park</label>
		<form:select class="form-control form-control-lg" id="favPark" name="favPark" required="required" path="favPark">
			<c:forEach items="${parks}" var="park">
				<option value="${park.parkCode}">${park.parkName}</option>
			</c:forEach>
		</form:select>
		<form:errors path="validPark"/>
		
	</div>
	<div class="form-group">
		<label for="email">Your Email</label>
		<form:input class="form-control form-control-lg" type="email" id="email" name="email" required="required" placeholder="email address" path="email"/>
		<form:errors path="email"/>
	</div>
	<div class="form-group">	
		<label for="stateRes">State of Residence</label>
		<form:select class="form-control form-control-lg" id="stateRes" name="stateRes" required="required" path="stateRes">
		<c:forEach items="${states}" var="state">
				<option>${state}</option>
			</c:forEach>
		</form:select>
		<form:errors path="validState"/>
		
	</div>
	<div class="form-check">
		<form:radiobutton class="form-check-input" id="inactive" name="activityLvl" value="inactive" path="activityLvl"/>
		<label class="form-check-label" for="inactive">Inactive</label>
	</div>
	<div class="form-check">
		<form:radiobutton class="form-check-input" id="sedentary" name="activityLvl" value="sedentary" path="activityLvl"/>
		<label class="form-check-label" for="sedentary">Sedentary</label>
	</div>
	<div class="form-check">
		<form:radiobutton class="form-check-input" id="active" name="activityLvl" value="active" path="activityLvl"/>
		<label class="form-check-label" for="active">Active</label>
	</div>
	<div class="form-check">
		<form:radiobutton class="form-check-input" id="extremelyActive" name="activityLvl" value="extremelyActive" path="activityLvl"/>
		<label class="form-check-label" for="extremelyActive">Extremely Active</label>
		<form:errors path="validActivityLevel"/>
	</div>
	<br>
	<button class="btn btn-outline-primary" type="submit">Submit</button>
</form:form>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />