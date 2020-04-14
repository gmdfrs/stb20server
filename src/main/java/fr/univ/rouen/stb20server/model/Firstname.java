package fr.univ.rouen.stb20server.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Model pour Firstname
 * @author Yeser GOUMIDI
 */

@XmlRootElement(name="firstname")
@XmlType(name="firstname")
@XmlAccessorType(XmlAccessType.FIELD)
public class Firstname implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@XmlValue
	private String firstname;
	
	@XmlAttribute(name = "gender")
	private String gender;
	
	@XmlAttribute(name = "lastname")
	private String lastname;
	
	@XmlAttribute(name = "email")
	private String email;
		
	public Firstname(String firstname, String gender, String lastname, String mail) {
		super();
		this.firstname 	= firstname;
		this.gender 	= gender;
		this.lastname   = lastname;
		this.email 		= mail;
	}
	
	public Firstname() {
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	
	
	public String getMail() {
		return this.email;
	}
	
	public void setMail(String mail) {
		this.email = mail;
	}
	
	@Override
	public String toString() {
		return ("firstname [firstname=" + firstname + "<br/>" +
							",gender=" + gender + "<br/>" + 
							",lastname=" + lastname + "<br/>" +
							",mail=" + email + "]");
	}
	
}

