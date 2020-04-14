package fr.univ.rouen.stb20server.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model pour Person
 * @author Yeser GOUMIDI
 */

@Entity
@Table(name = "person")
@XmlRootElement
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@XmlElement(name = "firstname",  required = true)
	private Firstname firstname;
		
	@XmlElement
	@OneToMany(mappedBy="person")
	private List<Function> function;
	
	@ManyToOne
	private Team team;
	
	public Person(Firstname firstname, List<Function>function, Team team) {
		super();
		this.firstname 	= firstname;
		this.function 	= function;
		this.team = team;
	}
	
	public Person() {
	}

	@Override
	public String toString() {
		return ("person [firstname=" +"<br/>" + firstname + ",function=" + function  +"]");
	}
	
}

