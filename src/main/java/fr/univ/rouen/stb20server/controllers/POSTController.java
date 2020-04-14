package fr.univ.rouen.stb20server.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import fr.univ.rouen.stb20server.Repository.STBRepository;
import fr.univ.rouen.stb20server.model.ListSTB20;
import fr.univ.rouen.stb20server.model.STB;
/**
 * Controller pour la méthode POST 
 * @author Yeser GOUMIDI
 */
@Controller
public class POSTController {

	@Autowired
	private STBRepository stbRepository;
	
	/*
	 * Page Liste des STB
	 * URL /resume
	 * Méthode GET ou POST
	 * Opération Affiche la liste des STB stockées
     * Retour Flux XML
     * Liste résumée des STB présentes dans la base.
     * Pour chaque STB, ne seront affichés que les informations suivantes :
	 * • Identifiant de la STB,
	 * • Titre,
	 * • Version,
	 * • Date,
	 * • Description
	 */
	
	@PostMapping(path = "/resume", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody ListSTB20 listeSTB() throws IOException {
		
		
		List<STB> per = new ArrayList<>();
		ListSTB20 liststb = new ListSTB20();
		
		per = stbRepository.findAll();
		if(!per.isEmpty()) {
			for(int i=0; i<per.size();i++ ) {
				per.get(i).setClient(null);
				per.get(i).setDetail(null);
				per.get(i).setTeam(null);
			}
			
			liststb.getListStbs().addAll(per);
			return liststb;
		
		}else return null;
	}
}
