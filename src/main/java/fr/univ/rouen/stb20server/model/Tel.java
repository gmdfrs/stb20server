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
 * Model pour Tel
 * @author Yeser GOUMIDI
 */

@Entity
@Table(name = "tel")
@XmlRootElement
public class Tel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@XmlValue
	private String tel;
	
	@ManyToOne
	private Client client;
	
	public Tel(String tel, Client client) {
		super();
		this.tel = tel;
		this.client = client;
	}	
	
	
	public Tel() {
	}

	@Override
	public String toString() {
		return ("tel[" + tel + "]");
	}
	
}



