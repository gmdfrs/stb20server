package fr.univ.rouen.stb20server.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Model pour Team
 * @author Yeser GOUMIDI
 */
@Entity
@Table(name = "team")
@XmlRootElement
public class Team implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@XmlElement
	@OneToMany(mappedBy="team")
	private List<Person> person;
	
	public Team(List<Person> person) {
		super();
		this.person = person;
	}
	
	public Team() {
	}
	
	@Override
	public String toString() {
		return ("team [person=" + person + "]" + "<br/>");
	}
	
}

