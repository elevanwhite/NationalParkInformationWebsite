<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:forEach items="${parkResults}" var="result">
<img src="../img/parks/${result.getKey().imageName}"/>
<span> ${result.getKey().parkName}</span>
<span>${result.getValue()}</span>
<br>
</c:forEach>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />
