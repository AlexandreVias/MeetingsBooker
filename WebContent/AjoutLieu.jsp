<%@ page pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8"/>
		<title>Ajouter un lieu</title>
		<link type="text/css" rel="stylesheet" href="form.css" />
	</head>
	
	<body>
		<form method="post" action="ajoutlieu">
		
			<fieldset>
			
				<legend>Ajout lieu</legend>
				
				<p> Vous pouvez ajouter un lieu via ce formulaire.</p>
				
				<label for="num">Num lieu <span
				class"requis">*</span></label>
				
				<input type="text" id="num" name="num" value="<c:out
				value="${lieu.num}"/> " size="4" maxlength="60"/>
				
				<span class="erreur">${form.erreurs['num']}</span>
				
				<br/>
				
				<label for="numCateg">Num Catégorie <span
				class"requis">*</span></label>
				
				<input type="text" id="numCateg" name="numCateg" value="<c:out
				value="${catégorie.numCateg}"/> " size="4" maxlength="60"/>
				
				<span class="erreur">${form.erreurs['numCateg']}</span>
				
				<br/>
				
				<label for="nom">Nom lieu <span
				class"requis">*</span></label>
				
				<input type="text" id="nom" name="nom" value="<c:out
				value="${lieu.nom}"/> " size="4" maxlength="60"/>
				
				<span class="erreur">${form.erreurs['nom']}</span>
				
				<br/>
				
				<label for="adresse">Adresse lieu <span
				class"requis">*</span></label>
				
				<input type="text" id="adresse" name="adresse" value="<c:out
				value="${lieu.adresse}"/> " size="10" maxlength="60"/>
				
				<span class="erreur">${form.erreurs['adresse']}</span>
				
				<br/>
				
				
				<label for="ville">Ville lieu <span
				class"requis">*</span></label>
				
				<input type="text" id="ville" name="ville" value="<c:out
				value="${lieu.ville}"/> " size="3" maxlength="60"/>
				
				<span class="erreur">${form.erreurs['ville']}</span>
				
				<br/>
				
				<label for="codepostal">CP lieu <span
				class"requis">*</span></label>
				
				<input type="text" id="codepostal" name="codepostal" value="<c:out
				value="${lieu.codepostal}"/> " size="5" maxlength="5"/>
				
				<span class="erreur">${form.erreurs['codepostal']}</span>
				
				<br/>
			
				<label for="descriptif">Descriptif lieu <span
				class"requis">*</span></label>
				
				<input type="text" id="descriptif" name="descriptif" value="<c:out
				value="${lieu.descriptif}"/> " size="3" maxlength="60"/>
				
				<span class="erreur">${form.erreurs['descriptif']}</span>
				
				<br/>
				
				<label for="coordonnees">Coordonnées lieu <span
				class"requis">*</span></label>
				
				<input type="text" id="coordonnees" name="coordonnees" value="<c:out
				value="${lieu.coordonnees}"/> " size="3" maxlength="60"/>
				
				<span class="erreur">${form.erreurs['"coordonnees"']}</span>
				
				<br/>
				
				<label for="annulationgratuite">Annulation gratuite lieu <span
				class"requis">*</span></label>
				
				<input type="text" id="annulationgratuite" name="annulationgratuite" value="<c:out
				value="${lieu.annulationgratuite}"/> " size="5" maxlength="5"/>
				
				<span class="erreur">${form.erreurs['annulationgratuite']}</span>
				
				<br/>
				
				<label for="note">Note lieu <span
				class"requis">*</span></label>
				
				<input type="text" id="note" name="note" value="<c:out
				value="${lieu.note}"/> " size="5" maxlength="5"/>
				
				<span class="erreur">${form.erreurs['note']}</span>
				
				<br/>
				
				<input type="submit" value="Ajouter" classe"sansLabel"/>
				
				<br/>
				
				<p class="${empty form.erreurs ? 'succes' :
				'erreur'}">${form.resultat}<p>
		
			</fieldset>
		
		</form>
	
	</body>
	
</html>