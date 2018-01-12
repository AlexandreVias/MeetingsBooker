<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <title>Recherche des lieux</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>

    <body>
        <form method="post" action="rechercheLieu">
            <fieldset>
                <legend>Rechercher un lieu</legend>
                <label for="ville">Ville :<span class="requis">*</span></label>
                <input type="text" id="ville" name="ville" value="<c:out value="${Lieu.ville}"/>"/>
                <span class="erreur">${form.erreurs['ville']}</span>
                <br />
                
                <label for="nbConvives">Nombre de convives<span class="requis">*</span></label>
                <input type="text" id="nbConvives" name="nbConvives" value="<c:out value="${Reservation.nbConvives}"/>"/>
                <span class="erreur">${form.erreurs['nbConvives']}</span>
                <br />
                
                <label for="duree">Durée :<span class="requis">*</span></label>
                <input type="text" id="duree" name="duree" value="<c:out value="${Lieu.duree}"/>"/>
                <span class="erreur">${form.erreurs['duree']}</span>
                <br />
                
                <label for="dateResa">Date de début :<span class="requis">*</span></label>
                <input type="text" id="dateResa" name="dateResa" value="<c:out value="${Reservation.dateResa}"/>"/>
                <span class="erreur">${form.erreurs['dateResa']}</span>
                <br />
                
                <input type="submit" value="Rechercher" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
              </fieldset>
          </form>
      </body>

  </html>
