package fr.univ.rouen.stb20server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Model pour ListSTB20
 * @author Yeser GOUMIDI
 */

@Entity
@Table(name = "stbs")
@XmlRootElement(name = "stb")
public class ListSTB20 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@XmlElement(name = "stb",  required = true)
	@OneToMany(mappedBy="stbs")
	private List<STB> stb; 
	 	
	public ListSTB20() {
		this.stb = new ArrayList<>();
	}
	
	public Long getId() {
		return this.id;
	}
	
	@XmlTransient
	public  List<STB> getListStbs() {
		return stb;
	}
	
	public void setListStbs(List<STB> stbs) {
		this.stb = stbs;
	}
	
	@Override
	public String toString() {
		return ("STB [Id=" + id + ",Stbs=" + stb + "]");
	}
}
