<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Liste des stations</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>

    <body>
	Liste des stations:
       <table border=1>
       <tr>
       		<td> Nom </td>
       		<td> Adresse </td>
       		<td> Ville </td>
       		<td> Code postal </td>
       		<td> Nombre de places </td>
       </tr>
       <c:forEach items="${ listestations }" var="station" varStatus="status">
       		<tr>
       			<td>
    				<c:out value="${ station.nom }" /> 
    			</td>
    			<td>
    				<c:out value="${ station.adresse }" /> 
    			</td>  			
    			<td>   	
    				<c:out value="${ station.ville }" /> 
    			</td>
    			<td>   	
    				<c:out value="${ station.codePostal }" /> 
    			</td>
    			<td>   	
    				<c:out value="${ station.nbPlaces }" /> 
    			</td>
      		 </tr>
	   </c:forEach>      
       </table>
    </body>

</html>