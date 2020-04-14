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
 * Model pour Function
 * @author Yeser GOUMIDI
 */
@Entity
@Table(name = "function")
@XmlRootElement
public class Function implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@XmlValue
	private String function;
	
	@ManyToOne
	private Person person;
	
	public Function(String func, Person person) {
		super();
		this.function = func;
		this.person = person;
	}	
	
	
	public Function() {
	}

	@Override
	public String toString() {
		return ("function [" + function + "]");
	}
	
}
