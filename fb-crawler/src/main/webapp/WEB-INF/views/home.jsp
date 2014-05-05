<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>

<link href="<c:url value="/static/base.css" />" rel="stylesheet">
<link href="<c:url value="/static/skeleton.css" />" rel="stylesheet">
<link href="<c:url value="/static/layout.css" />" rel="stylesheet">

</head>
<body>

	<div class="container">

		<div id="logo_lsi" class="sixteen columns">
			<img src="static/lsi.png" alt="Laboratório de Sistemas de Informação"
				title="Laboratório de Sistemas de Informação" />
		</div>

		<div id="nav" class="sixteen columns">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="http://lsi.facom.ufu.br/sobre">Sobre</a></li>
				<li><a href="http://lsi.facom.ufu.br/equipe/">Contato</a></li>
			</ul>
		</div>

		<div id="theText" class="eight columns">
			<h3>Termo</h3>
			<p align="justify">Você está sendo convidado (a) para participar
				da pesquisa intitulada "Sistemas de Recomendação Sociais Dinâmicos:
				Teoria, Implementação e Aplicações", sob a responsabilidade da
				pesquisadora M.Sc. Cricia Zilda Felício Paixão.</p>
			<p align="justify">A pesquisa tem por objetivo comprovar a
				influência dos contatos sociais de uma pessoa em suas preferências.
				A participação na pesquisa compreenderá a avaliação de um conjunto
				de filmes através de um aplicativo na rede social Facebook, o
				aplicativo fará ainda a aquisição das informações pessoais, de
				interação e contatos.</p>
			<p align="justify">Em nenhum momento você será identificado. Os
				resultados da pesquisa serão publicados e ainda assim a sua
				identidade será preservada.</p>
			<p align="justify">Você não terá nenhum gasto e ganho financeiro
				por participar na pesquisa. Os dados servirão para testes de um
				recomendador social. Você é livre para deixar de participar da
				pesquisa a qualquer momento sem nenhum prejuízo ou coação.</p>
			<br />

			<form name="filmes" action="filmes" method="post">
				<input type="submit" value="Participar!">
			</form>

		</div>

		<div id="bigphoto" class="seven columns add-bottom offset-by-one">
			<img src="static/p3.png">
		</div>
		<div class="clear"></div>
		<br />

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
