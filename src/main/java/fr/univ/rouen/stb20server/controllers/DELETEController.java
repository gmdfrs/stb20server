package fr.univ.rouen.stb20server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import fr.univ.rouen.stb20server.Repository.STBRepository;

/**
 * Controller pour la méthode DELET
 * @author Yeser GOUMIDI
 */
@RestController
public class DELETEController {

	/*
	 * Page Suppression d’un article
	 * URL /delete ?id=<id>
	 * <id> = valeur numérique de l’identifiant
	 * Méthode DELETE
	 * Opération Suppression de la STB dont l’identifiant est <id>
	 * Retour Flux XML
	 * Si l’opération à réussi, retour des informations suivantes :
	 * - id → numéro d’identifiant de la STB qui a été supprimée
	 * - status → DELETED
	 * Si l’opération à échoué (identifiant inconnu)
	 * - status → ERROR
	 */
	@Autowired
	private STBRepository stbRepository;
	
	@DeleteMapping("/delete")
	public String deleteArtSTB(@RequestParam(value = "id")  int id) {
		
		if(stbRepository.existsById((long) id)) {
			stbRepository.deleteById((long) id);
			
			return "<message>" + 
			"<id>"+ id +"</id>" + 
			"<status>"+ HttpStatus.OK +"</status>" + 
			"</message>";
			
		}else return "<message>" + 
			"<id>"+ id +"</id>" + 
			"<status>"+ HttpStatus.NOT_FOUND+"</status>" + 
			"</message>";
	}
}
