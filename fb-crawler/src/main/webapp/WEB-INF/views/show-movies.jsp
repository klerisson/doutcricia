<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/static/stars.css" />" rel="stylesheet">
<title>Movies</title>
</head>
<body>
	<h3>Filmes para avaliação:</h3>
	<ul>
		<c:forEach items="${filmes}" var="filme">
			<li>
				<img src="data:image/jpeg;base64,<c:out value="${filme.imgfilmeString}"/>"/><br />
				Título: <c:out value="${filme.titulofilme}" /><br />
				<span class="rating"> 
					<input type="radio" class="rating-input" id="rating-input-1-5" name="rating-input-1" /> 
					<label for="rating-input-1-5" class="rating-star"></label> 
					<input type="radio" class="rating-input" id="rating-input-1-4" name="rating-input-1" /> 
					<label for="rating-input-1-4" class="rating-star"></label> 
					<input type="radio" class="rating-input" id="rating-input-1-3" name="rating-input-1" />
					<label for="rating-input-1-3" class="rating-star"></label> 
					<input type="radio" class="rating-input" id="rating-input-1-2" name="rating-input-1" /> 
					<label for="rating-input-1-2" class="rating-star"></label> 
					<input type="radio" class="rating-input" id="rating-input-1-1" name="rating-input-1" />
					<label for="rating-input-1-1" class="rating-star"></label>
				</span>
			</li>
		</c:forEach>
	</ul>
</body>
</html>