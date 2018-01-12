<%@ page pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

    <head>

        <meta charset="utf-8" />

        <title>Liste des lieux</title>

        <link type="text/css" rel="stylesheet" href="form.css" />

    </head>

    <body>
	Liste des lieux:
       <table border=1>
       <tr>
       		<td> nom </td>
       		<td> adresse </td>
       		<td> ville </td>
       		<td> code postal </td>
       		<td> coordonnees </td>
       		<td> descriptif </td>
       		<td> annulationgratuite </td>
       		<td> note </td>
       		
       </tr>
       <c:forEach items="${ listelieux }" var="lieu" varStatus="status">
       		<tr>
       			<td>
       		
    				<c:out value="${ lieu.nom }" /> 
    			</td>
    			<td>
    	
    				<c:out value="${ lieu.adresse }" /> 
    			</td>
    			
    			<td>
    	
    				<c:out value="${ lieu.ville }" /> 
    			</td>
    			<td>
    	
    				<c:out value="${ lieu.codepostal }" /> 
    			</td>
    			<td>
    	
    				<c:out value="${ lieu.coordonnees }" /> 
    			</td>
    			<td>
    	
    				<c:out value="${ lieu.descriptif }" /> 
    			</td>
    			<td>
    	
    				<c:out value="${ lieu.annulationgratuite }" /> 
    			</td>
    			<td>
    	
    				<c:out value="${ lieu.note }" /> 
    			</td>
      		 </tr>
	   </c:forEach>
       
       
       </table>

    </body>

</html>