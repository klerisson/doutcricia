<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>

<link href="<c:url value="/static/base.css" />" rel="stylesheet">
<link href="<c:url value="/static/skeleton.css" />" rel="stylesheet">
<link href="<c:url value="/static/layout.css" />" rel="stylesheet">
<link href="<c:url value="/static/stars.css" />" rel="stylesheet">
<script type="text/javascript">
function CliqueDoBotao(id, rating){
	alert(id + ' - ' + rating);
}
</script>
</head>
<body>

	<div class="container">

		<div id="logo_lsi" class="sixteen columns"><img src="static/lsi.png" alt="Laboratório de Sistemas de Informação" title="Laboratório de Sistemas de Informação" /></div>

		<div id="nav" class="sixteen columns">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="http://lsi.facom.ufu.br/sobre">Sobre</a></li>
				<li><a href="http://lsi.facom.ufu.br/equipe/">Contato</a></li>
			</ul>
		</div>
		
		<div id="theText" class="sixteen columns">			
			<c:forEach items="${filmes}" var="filme">
				<div class="filmeItem">
					<img src="data:image/jpeg;base64,<c:out value="${filme.imgfilmeString}"/>" alt="<c:out value="${filme.titulofilme}" />" title="<c:out value="${filme.titulofilme}" />" /><br />
					<div>
						<span><c:out value="${filme.titulofilme.substring(0, 3)}" /></span><br />
						<span class="rating"> 
							<input type="radio" class="rating-input" id="rating-input-<c:out value="${filme.idfilme}"/>-5" name="rating-input-<c:out value="${filme.idfilme}"/>" onclick="CliqueDoBotao('<c:out value="${filme.idfilme}" />', 5);" /> 
							<label for="rating-input-<c:out value="${filme.idfilme}"/>-5" class="rating-star"></label> 
							<input type="radio" class="rating-input" id="rating-input-<c:out value="${filme.idfilme}"/>-4" name="rating-input-<c:out value="${filme.idfilme}"/>" onclick="CliqueDoBotao('<c:out value="${filme.idfilme}" />', 4);" /> 
							<label for="rating-input-<c:out value="${filme.idfilme}"/>-4" class="rating-star"></label> 
							<input type="radio" class="rating-input" id="rating-input-<c:out value="${filme.idfilme}"/>-3" name="rating-input-<c:out value="${filme.idfilme}"/>" onclick="CliqueDoBotao('<c:out value="${filme.idfilme}" />', 3);" />
							<label for="rating-input-<c:out value="${filme.idfilme}"/>-3" class="rating-star"></label> 
							<input type="radio" class="rating-input" id="rating-input-<c:out value="${filme.idfilme}"/>-2" name="rating-input-<c:out value="${filme.idfilme}"/>" onclick="CliqueDoBotao('<c:out value="${filme.idfilme}" />', 2);" /> 
							<label for="rating-input-<c:out value="${filme.idfilme}"/>-2" class="rating-star"></label> 
							<input type="radio" class="rating-input" id="rating-input-<c:out value="${filme.idfilme}"/>-1" name="rating-input-<c:out value="${filme.idfilme}"/>" onclick="CliqueDoBotao('<c:out value="${filme.idfilme}" />', 1);" />
							<label for="rating-input-<c:out value="${filme.idfilme}"/>-1" class="rating-star"></label>
						</span>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>
