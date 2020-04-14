package fr.univ.rouen.stb20server.controllers;

import java.io.IOException;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import fr.univ.rouen.stb20server.Repository.STBRepository;
import fr.univ.rouen.stb20server.model.ListSTB20;
import fr.univ.rouen.stb20server.model.STB;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
/**
 * Controller pour la méthode GET 
 * @author Yeser GOUMIDI
 */
@Controller
public class GETController {
	
	private Marshaller jaxbMarshaller;
	private JAXBContext jaxbContext;
	
	@Autowired
	private STBRepository stbRepository;
	
	/*
	 * 	Page d'accueil
	 *  URL /
	 * 	Format HTML ou XHTML valide
	 *	Affiche la page d’accueil du projet avec les informations suivantes :
     * • Nom du projet,
     * • Numéro de version,
     * • Nom & Prénom de l’auteur(e),
     * • Logo de l’Université de Rouen
	 */
	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	/*
	 * Page Aide
	 * URL /help
	 * Méthode GET
	 * Opération Affiche la page contenant les informations d’aide
	 * Retour Format XHTML ou XHTML valide
	 * Affiche la liste des opérations gérées par le service REST.
	 * Pour chacune des opérations proposées par le service, sont affichés :
	 * • URL,
	 * • Méthode attendue,
	 * • Résumé de l’opération (format attendu, format de retour, ...)
	 */
	@RequestMapping("/help")
	public String help(ModelMap model) {
		return "help";
	}
	
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
	
	
	@GetMapping(path = "/resume", produces = MediaType.APPLICATION_XML_VALUE)
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
	
	/*
	 * Page Détail d’une STB
	 * URL /stb?id=<id>
	 * <id> = valeur numérique de l’identifiant
	 * Méthode GET
	 * Opération Retourne le contenu complet de la STB dont l’identifiant est <id>
	 * Retour Flux XML conforme au schéma XSD d'une STB
	 * Si l’identifiant est incorrect, retour d’un message d’erreur au format XML contenant :
	 * - id → numéro de l’identifiant demandé
	 * - status →ERROR
	 */
	
	@GetMapping(path = "/stb", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody String DetailSTB(@RequestParam(value = "id") int id) throws JAXBException {
		
		if(stbRepository.existsById((long) id)) {
			
			Optional<STB> stbli =  stbRepository.findById((long) id);
			jaxbContext = JAXBContext.newInstance(STB.class);
			jaxbMarshaller = jaxbContext.createMarshaller();
			StringWriter sw = new StringWriter();
	        jaxbMarshaller.marshal(stbli.get(), sw);
	        
	        return sw.toString();

		}else{

			return "<message>" + 
			"<id>"+ id +"</id>" + 
			"<status>"+ HttpStatus.NOT_FOUND +"</status>" + 
			"</message>";
		}
	}
	
	/*
	 * Page Détail d'une STB : Format HTML
	 * URL /htmlstb?id=<id>
	 * <id> = valeur numérique de l’identifiant
	 * Méthode GET
	 * Opération Retourne le contenu complet de la STB dont l’identifiant est <id>
 	 * Retour Idem précédent, mais au format HTML
	 */
	
	@RequestMapping("/htmlstb")
	public String DetailHtmlSTB(@RequestParam(value = "id") int id, ModelMap model) {

		if(stbRepository.existsById((long) id)) {
			STB stb = stbRepository.getOne((long) id);
			
			model.addAttribute("stb", stb);
			return "htmlstb";
		}else {
			// HttpStatus.BAD_REQUEST
			model.addAttribute("id", id);
			return "404";
		}
	}
}
