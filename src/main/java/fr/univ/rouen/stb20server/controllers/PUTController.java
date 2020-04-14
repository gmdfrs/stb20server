package fr.univ.rouen.stb20server.controllers;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import fr.univ.rouen.stb20server.Repository.STBRepository;
import fr.univ.rouen.stb20server.model.Client;
import fr.univ.rouen.stb20server.model.Detail;
import fr.univ.rouen.stb20server.model.Feature;
import fr.univ.rouen.stb20server.model.Firstname;
import fr.univ.rouen.stb20server.model.Function;
import fr.univ.rouen.stb20server.model.Mail;
import fr.univ.rouen.stb20server.model.Person;
import fr.univ.rouen.stb20server.model.STB;
import fr.univ.rouen.stb20server.model.Team;
import fr.univ.rouen.stb20server.model.Tel;
import fr.univ.rouen.stb20server.util.StbNotValidException;
import fr.univ.rouen.stb20server.util.Validator;


/**
 * Controller pour la méthode PUT
 * @author Yeser GOUMIDI
 */
@RestController
public class PUTController {

	@Autowired
	private STBRepository stbRepository;
	
	JAXBContext jaxbContext;
    Unmarshaller jaxbUnmarshaller;
	/*
	 * Page Ajout d’une STB dans la base
	 * URL /insert
	 * Méthode PUT
	 * Transmis Flux XML décrivant la STB à ajouter, conformément au schéma XSD.
	 * Opération Le flux reçu est validé par le schéma XSD de définition STB20
	 * Si le flux est déjà présent (titre et version identique) alors une indication d’erreur est retournée.
	 * Si l’opération réussie, alors le flux est ajouté à la base et sa persistance est assurée
	 * La valeur d'identifiant est automatiquement créée si l'insertion est effectuée.
	 * Retour Le flux XML retourné contient les informations suivantes :
	 * - id → numéro d’identifiant attribué à la nouvelle STB enregistrée
	 * - status → INSERTED
	 * En cas d’échec de l’opération, seule la valeur de statut est retournée
	 * - status → ERROR
	 */
	
    
	@RequestMapping(value = "/insert", method = RequestMethod.PUT, consumes = "application/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public String insertSTB(@RequestBody String stb) throws StbNotValidException {
	
	// creation du validator
	 Validator stbValidator = new Validator();
	 
		try {
			
			
			stbValidator.validate(stb);
			
            jaxbContext = JAXBContext.newInstance(STB.class, Firstname.class, Client.class, Mail.class, 
            		Tel.class, Detail.class, Feature.class, Function.class, Person.class, Team.class);
            
            jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
            STB stbObject = (STB) jaxbUnmarshaller.unmarshal(new StringReader(stb));
			
            // sauvgarder le stb dans la base de donnée
            STB stbResponse = stbRepository.save(stbObject);
            
		    if(stbResponse != null) return "<message>" + 
									"<id>"+ stbObject.getId() +"</id>" + 
									"<status>"+ HttpStatus.OK +"</status>" + 
									"</message>";
	        
		    else return "<message>" + 
						"<status>"+ HttpStatus.NOT_ACCEPTABLE +"</status>" + 
						"</message>";
	
		} catch (Exception exp) {
			throw new StbNotValidException(exp.getMessage()+exp);
		}
	}


}
