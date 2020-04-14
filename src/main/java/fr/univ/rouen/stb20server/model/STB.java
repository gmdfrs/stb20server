package fr.univ.rouen.stb20server.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Model pour STB
 * @author Yeser GOUMIDI
 */

@Entity
@Table(name = "stb")
@XmlRootElement(name = "stb")
@XmlType(propOrder={"title", "version", "date", "description", "client", "team", "detail"})
public class STB implements Serializable{
	
	private static final long serialVersionUID = 2L;
	
	@Id
	@XmlAttribute(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title",  length = 128)
	@XmlElement(name = "title",  required = true)
	private String title;

	@Column(name = "version")
	@XmlElement(name = "version",  required = true)
	private String version;
	
	@Column(name = "date")
	@XmlElement(name = "date",  required = true)
	private String date;
	
	@Column(name = "description", length = 128)
	@XmlElement(name = "description",  required = true)
	private String description;
	
	@Column(name = "client")
	@XmlElement(type= Client.class, required = true)
	private Client client;
	
	@Column(name = "team")
	@XmlElement(type= Team.class, required = true)
	private Team team;
	
	@Column(name = "detail")
	@XmlElement(type= Detail.class, required = true)
	private Detail detail;
	
	@ManyToOne
	private ListSTB20 stbs;
	
	public STB(String title, String version, String date, String description, Client client, Team team, Detail detail) {
		super();
		this.title 		= title;
		this.version 	= version;
		this.date 		= date;
		this.description= description;
		this.client 	= client;
		this.team 		= team;
		this.detail 	= detail;
	}
	
	public STB() {
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setClient(Client client) {
		 this.client = client;
	}
	
	public void setTeam(Team team) {
		 this.team = team;
	}
	
	public void setDetail(Detail detail) {
		 this.detail = detail;
	}
	
	@Override
	public String toString() {
		return ("STB {" + 
					"id=" + id +
					",title=" + title + "<br/>" +
					",version=" + version + "<br/>" +
					",date=" + date +  "<br/>" +
					",description=" + description + "<br/>" +
					",client=" + client + "<br/>" +
					",team=" + team + "<br/>" +
					",detail=" + detail +
				"}");
	}
}
