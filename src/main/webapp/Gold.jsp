<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Ninja Gold</title>
	</head>
	<body>
		<div class='container'>
			<div id='gold'>
				<label>Your Gold: <span><c:out value='${ninja.getGold()}'/></span></label>
			</div>
			<div id='tablebox'>	<!--<<PUT BUTTONS IN FORMS>>-->
				<table>
					<tbody>
						<tr>
							<td class='place'>
								<h1>Farm</h1><br/><br/>
								<h3>(earns 10-20 gold)</h3><br/><br/>
								<form action="/find" method="post">
									<button id='btn_farm'>Find Gold!</button>
									<input type="hidden" name="location" value="farm">
								</form>
							</td>
							<td class='place'>
								<h1>Cave</h1><br/><br/>
								<H3>(earns 5-10 gold)</H3><br/><br/>
								<form action="/find" method="post">
									<button id='btn_cave'>Find Gold!</button>
									<input type="hidden" name="location" value="cave">
								</form>
							</td>
							<td class='place'>
								<h1>House</h1><br/><br/>
								<h3>(earns 2-5 gold)</h3><br/><br/>
								<form action="/find" method="post">
									<button id='btn_house'>Find Gold!</button>
									<input type="hidden" name="location" value="house">
								</form>
							</td>
							<td class='place'>
								<h1>Casino!</h1><br/><br/>
								<h3>(win/lose 0-50 gold)</h3><br/><br/>
								<form action="/find" method="post">
									<button id='btn_casino'>Find Gold!</button>
									<input type="hidden" name="location" value="casino">
								</form>
							</td>
						</tr>
					</tbody>
				</table>			
			</div>
		</div>
		<div class='container'>
			<ul class='nobullet'>
			<c:set var='hSize' value='${ninja.getHistory().size()}' />
				<c:forEach var='i' begin='1' end='${hSize}' step='1'>
					<c:set var='log' value='${ninja.getHistory().get(hSize - i)}'/>
					<li class='<c:out value="${log.getColor()}"/>'><c:out value="${log.getText()}"/></li>
				</c:forEach>
			</ul>
		</div>
		<div class='container'>
			<form action="/find" method="post">
				<button id='btn_reset'> --- Reset --- </button>
				<input type="hidden" name="location" value="reset">
			</form>				
		</div>
	</body>
</html>
















