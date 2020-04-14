<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>

<!-- page help -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Help</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<div class="intro">
<h1>STB20 REST HELP</h1>
<p><span>La Page</span> affiche la liste des opérations gérées par notre service REST.</p>
</div>

<table>
      <thead>
        <tr>
          <th scope="col">URL</th>
          <th scope="col">METHODE ATTENDUE</th>
          <th scope="col">ACTION</th>
        </tr>
      </thead>
      <tfoot>
        <tr>
          <td colspan="3" style="text-align: center;"> Projet Web2 - 2019/2020</td>
        </tr>
      </tfoot>
      <tbody>
        <tr>
          <th scope="row">/</th>
          <td>GET</td>
          <td>Retourne la page d'accueil avec un message identifiant le projet</td>
        </tr>

        <tr>
          <th scope="row">/help</th>
          <td>GET</td>
          <td>Retourne la liste des opérations gérées par le service REST</td>
        </tr>

        <tr>
          <th scope="row">/resume</th>
          <td>GET / POST</td>
          <td>Retourne une liste résumée les STB présentes dans la base en flux XML avec 
          les informations suivantes :
		<ul>
			<li>Identifiant de la STB</li>
			<li>Titre</li>
			<li>Version</li>
			<li>Date</li>
			<li>Description</li>
		</ul>
        </tr>

        <tr>
          <th scope="row">/stb/{id}</th>
          <td>GET</td>
          <td>Opération Retourne le contenu complet de la STB dont l’identifiant est {id}, 
	          Retour Flux XML conforme au schéma XSD d'une STB.
	      </td>
        </tr>

		<tr>
          <th scope="row">/htmlstb/{id}</th>
          <td>GET</td>
          <td>Opération Retourne le contenu complet de la STB dont l’identifiant est {id}
 	 		  en format HTML.
	      </td>
        </tr>


        <tr>
          <th scope="row">/insert</th>
          <td>PUT</td>
          <td>Transmis Flux XML décrivant la STB à ajouter, conformément au schéma XSD.
	 	  </td>
        </tr>

        <tr>
          <th scope="row">/delete/{id}</th>
          <td>DELETE</td>
          <td>Suppression de la STB dont l’identifiant est {id}, Retour Flux XML
	 	  </td>
        </tr>
      </tbody>
    </table>

</body>
</html>