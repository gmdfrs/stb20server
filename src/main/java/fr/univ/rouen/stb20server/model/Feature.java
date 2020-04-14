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
 * Model pour Feature
 * @author Yeser GOUMIDI
 */

@Entity
@Table(name = "feature")
@XmlRootElement
@XmlType(name = "Feature", propOrder={"name", "section", "number", "description", "priority", "delivery"})
public class Feature implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = true, length = 32)
	@XmlAttribute(name = "name",  required = true)
	private String name;
	
	@Column(name = "section")
	@XmlAttribute(name = "section",  required = true)
	private Integer section;
	
	@Column(name = "number")
	@XmlAttribute(name = "number",  required = true)
	private Integer number;
	
	@Column(name = "description", nullable = true, length = 128)
	@XmlElement(name = "description",  required = true)
	private String description;
	
	@Column(name = "priority", length = 10)
	@XmlElement(name = "priority",  required = true)
	private Integer priority;
	
	@Column(name = "delivery", nullable = true)
	@XmlElement(name = "delivery",  required = false)
	private String delivery;
	
	@ManyToOne
	private Detail detail;
	
	
	public Feature(String name, Integer section, Integer number, String description, Integer priority, String delivery, Detail detail) {
		super();
		this.name 		= name;
		this.section   = section;
		this.number 	= number;
		this.description 	= description;
		this.priority 	= priority;
		this.delivery 	= delivery;
		this.detail = detail;
	}
	
	public Feature() {
	}
	
	@Override
	public String toString() {
		return ("feauture [name=" + name + "<br/>" + 
							",section=" +  section + "<br/>" + 
							",number=" + number + "<br/>" +
							",description=" + description + "<br/>" +
							",priority=" + priority + "<br/>" +
							",Delivery=" + delivery  +"]");
	}
}

