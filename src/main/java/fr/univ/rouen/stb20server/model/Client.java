package fr.univ.rouen.stb20server.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Model pour Client
 * @author Yeser GOUMIDI
 */

@Entity
@Table(name = "client")
@XmlRootElement
@XmlType(name = "Client", propOrder={"entity", "firstname", "lastname", "email", "tel"})
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "entity", nullable = false, length = 32)
	@XmlElement(name = "entity",  required = true)
	private String entity;
	
	@Column(name = "firstname", nullable = false, length = 32)
	@XmlElement(name = "firstname",  required = true)
	private String firstname;
	
	@Column(name = "lastname", nullable = true, length = 32)
	@XmlElement(name = "lastname",  required = false)
	private String lastname;
	
	@XmlElement
	@OneToMany(mappedBy = "client")
	private List <Mail> email;
	
	@XmlElement
	@OneToMany(mappedBy = "client")
	private List<Tel> tel;
	
	public Client(String entity, String firsname, String lastename, List<Mail> mail, List<Tel> tel) {
		super();
		this.entity = entity;
		this.firstname = firsname;
		this.lastname = lastename;
		this.email = mail;
		this.tel = tel;
	}	
	
	
	public Client() {
	}

	@Override
	public String toString() {
		return ("client [Entity=" + entity + "<br/>" +
						",firsname=" + firstname + "<br/>" +
						",lastname=" + lastname + "<br/>" +
						",mail=" + email + "<br/>" + 
						",tel=" + tel + "]"+ "<br/>");
	}
	
}



