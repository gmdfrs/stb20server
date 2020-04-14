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
 * Model pour Detail
 * @author Yeser GOUMIDI
 */

@Entity
@Table(name = "detail")
@XmlRootElement
public class Detail implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@XmlElement
	@OneToMany(mappedBy="detail")
	private List<Feature> feature;
	
	
	public Detail(List<Feature> feature) {
		super();
		this.feature 	= feature;		
		
	}
	
	public Detail() {
	}
	
	@Override
	public String toString() {
		return ("detail[feature=" + feature + "]"+ "<br/>");
	}
}


	
	
	
	

	
