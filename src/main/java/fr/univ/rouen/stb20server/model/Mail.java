package fr.univ.rouen.stb20server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
/**
 * Model pour Mail
 * @author Yeser GOUMIDI
 */

@Entity
@Table(name = "mail")
@XmlRootElement
public class Mail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@XmlValue
	private String email;
	
	@ManyToOne
	private Client client;
	
	public Mail(String email, Client client) {
		super();
		this.email = email;
		this.client = client;
	}	
	
	
	public Mail() {
	}

	@Override
	public String toString() {
		return ("mail ["  + email + "]");
	}
	
}



