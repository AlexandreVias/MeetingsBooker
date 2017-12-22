<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Ajout d'une station</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>

    <body>
        <form method="post" action="ajoutStation">
            <fieldset>
                <legend>Ajouter une station</legend>
                <label for="nom">Nom de la station<span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="<c:out value="${station.nom}"/>" size="30" maxlength="60" />
                <span class="erreur">${form.erreurs['nom']}</span>
                <br />
                
                <label for="adresse">Adresse de la station<span class="requis">*</span></label>
                <input type="text" id="adresse" name="adresse" value="<c:out value="${station.adresse}"/>" size="26" maxlength="60" />
                <span class="erreur">${form.erreurs['adresse']}</span>
                <br />
                
                <label for="ville">Ville de la station<span class="requis">*</span></label>
                <input type="text" id="ville" name="ville" value="<c:out value="${station.ville}"/>" size="30" maxlength="60" />
                <span class="erreur">${form.erreurs['ville']}</span>
                <br />
                
                <label for="codepostal">Code postal de la station<span class="requis">*</span></label>
                <input type="text" id="codepostal" name="codepostal" value="<c:out value="${station.codePostal}"/>" size="22" maxlength="5" />
                <span class="erreur">${form.erreurs['codepostal']}</span>
                <br />
                
                <label for="nbplaces">Nombre de place de la station<span class="requis">*</span></label>
                <input type="text" id="nbplaces" name="nbplaces" value="<c:out value="${station.nbPlaces}"/>" size="16" maxlength="2" />
                <span class="erreur">${form.erreurs['nbplaces']}</span>
                <br />
                
                <input type="submit" value="Ajouter" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
              </fieldset>
          </form>
      </body>

  </html>
