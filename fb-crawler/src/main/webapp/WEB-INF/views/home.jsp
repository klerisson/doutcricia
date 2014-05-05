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
			<img src="static/lsi.png" alt="Laborat�rio de Sistemas de Informa��o"
				title="Laborat�rio de Sistemas de Informa��o" />
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
			<p align="justify">Voc� est� sendo convidado (a) para participar
				da pesquisa intitulada "Sistemas de Recomenda��o Sociais Din�micos:
				Teoria, Implementa��o e Aplica��es", sob a responsabilidade da
				pesquisadora M.Sc. Cricia Zilda Fel�cio Paix�o.</p>
			<p align="justify">A pesquisa tem por objetivo comprovar a
				influ�ncia dos contatos sociais de uma pessoa em suas prefer�ncias.
				A participa��o na pesquisa compreender� a avalia��o de um conjunto
				de filmes atrav�s de um aplicativo na rede social Facebook, o
				aplicativo far� ainda a aquisi��o das informa��es pessoais, de
				intera��o e contatos.</p>
			<p align="justify">Em nenhum momento voc� ser� identificado. Os
				resultados da pesquisa ser�o publicados e ainda assim a sua
				identidade ser� preservada.</p>
			<p align="justify">Voc� n�o ter� nenhum gasto e ganho financeiro
				por participar na pesquisa. Os dados servir�o para testes de um
				recomendador social. Voc� � livre para deixar de participar da
				pesquisa a qualquer momento sem nenhum preju�zo ou coa��o.</p>
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
					title="Universidade Federal de Uberlândia"> <img
					src="static/ufu-logo.png" />
				</a>

			</div>
			Laborat�rio de Sistemas de Informa��o <br> <a
				href="http://www.facom.ufu.br/">Faculdade de Computa��o - </a><a
				href="http://www.ufu.br/">Universidade Federal de Uberl�ndia</a> <br>Av.
			Jo�o Naves de �vila, 2121, Campus Santa M�nica - Bloco 5K <br>CEP:
			38.400-902 - Uberl�ndia - Minas Gerais - Brasil<br>Fone: 55 (34)
			3239-4568<br>&nbsp;<br>&nbsp;
		</div>
	</div>




</body>
</html>
