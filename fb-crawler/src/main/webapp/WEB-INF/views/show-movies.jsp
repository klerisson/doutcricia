<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>

<link rel="icon" href="favicon.ico" type="image/x-icon" />
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />


<script src="<c:url value="/static/jquery-1.9.1.min.js" />"></script>
<link href="<c:url value="/static/rating.css" />" rel="stylesheet">
<link href="<c:url value="/static/base.css" />" rel="stylesheet">
<link href="<c:url value="/static/skeleton.css" />" rel="stylesheet">
<link href="<c:url value="/static/layout.css" />" rel="stylesheet">

<script type="text/javascript">
	
$(document).ready(function(){
	
	$(':radio').change(
		  function(){
		    		    
		    var avaliacao = {
					idfilme : this.name,
					nota : this.value,
					idusuario : null,
			};
		    
		    $.ajax({
				url : "/fb-crawler/rate",
				type : 'POST',
				dataType : 'json',
				data : JSON.stringify(avaliacao),
				contentType : 'application/json',
				mimeType : 'application/json',
				async : false,
				cache : false,
				processData : false,
				success : function(data) {
					if (data.status == 'OK')
						;
					else
						alert(data.errorMessage);
				}
			});
		  
		  }		  
	);
});
	

	
	
</script>
</head>
<body>

	<div class="container">

		<div id="logo_lsi" class="sixteen columns">
			<img src="static/lsi.png" alt="Laboratório de Sistemas de Informação"
				title="Laboratório de Sistemas de Informação" />
		</div>

		<div id="nav" class="sixteen columns">
			<ul>
				<li><a href="home">Home</a></li>
				<li><a href="http://lsi.facom.ufu.br/sobre">Sobre</a></li>
				<li><a href="http://lsi.facom.ufu.br/equipe/">Contato</a></li>
			</ul>
		</div>

		<div id="theText" class="sixteen columns">
			<c:forEach items="${filmes}" var="filme" varStatus="myIndex">
				<div class="filmeItem">
					<img
						src="data:image/jpeg;base64,<c:out value="${filme.imgfilmeString}"/>"
						alt="<c:out value="${filme.titulofilme}" />"
						title="<c:out value="${filme.titulofilme}" />" /><br />
					<div>
						<span><c:out value="${filme.titulofilme}" /></span> <br /> 
						<span class="star-rating">
							<c:forEach var="i" begin="1" end="5">
								<input type="radio" <c:out value="${ratings[myIndex.index].nota == i ? 'checked' : ''}"/> name="<c:out value="${filme.idfilme}"/>" value="${i}"><i></i>
							</c:forEach>
						</span>
					</div>
				</div>
			</c:forEach>
			<div align="center">
				<br />
				<br />
				<input type=button onClick="location.href='home'" value='Obrigado por participar!'>
				<br />
				<br />
			</div>
		</div>
		<div id="rodape">
			<div id="logo_ufu" class="sixteen columns">
				<a href="http://www.ufu.br/"
					title="Universidade Federal de UberlÃ¢ndia"> <img
					src="static/ufu-logo.png" />
				</a>

			</div>
			Laboratório de Sistemas de Informação <br> <a
				href="http://www.facom.ufu.br/">Faculdade de Computação - </a><a
				href="http://www.ufu.br/">Universidade Federal de Uberlândia</a> <br>Av.
			João Naves de Ávila, 2121, Campus Santa Mônica - Bloco 5K <br>CEP:
			38.400-902 - Uberlândia - Minas Gerais - Brasil<br>Fone: 55 (34)
			3239-4568<br>&nbsp;<br>&nbsp;
		</div>
	</div>

</body>
</html>
