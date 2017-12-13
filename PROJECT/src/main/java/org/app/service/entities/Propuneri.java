package org.app.service.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.ALL;

@Entity
public class Propuneri {
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer IDIntern;
	private String NumeIntern;
	private Integer IDPost;
	private String NumePost;
	private String Oferta;
	
	@ManyToOne
	static private EvaluareFinala efinala;
	
	@OneToMany(mappedBy="propunere", cascade = ALL, fetch=FetchType.EAGER)
	static private List<Angajati> angajat = new ArrayList<>();

	public Propuneri(Integer iDIntern, String numeIntern, Integer iDPost, String numePost, String oferta,
			EvaluareFinala efinala, List<Angajati> angajat) {
		super();
		IDIntern = iDIntern;
		NumeIntern = numeIntern;
		IDPost = iDPost;
		NumePost = numePost;
		Oferta = oferta;
		this.efinala = efinala;
		this.angajat = angajat;
	}

	public Propuneri() {
		super();
	}

	public Integer getIDIntern() {
		return IDIntern;
	}

	public void setIDIntern(Integer iDIntern) {
		IDIntern = iDIntern;
	}

	public String getNumeIntern() {
		return NumeIntern;
	}

	public void setNumeIntern(String numeIntern) {
		NumeIntern = numeIntern;
	}

	public Integer getIDPost() {
		return IDPost;
	}

	public void setIDPost(Integer iDPost) {
		IDPost = iDPost;
	}

	public String getNumePost() {
		return NumePost;
	}

	public void setNumePost(String numePost) {
		NumePost = numePost;
	}

	public String getOferta() {
		return Oferta;
	}

	public void setOferta(String oferta) {
		Oferta = oferta;
	}

	static public EvaluareFinala getEfinala() {
		return efinala;
	}

	public void setEfinala(EvaluareFinala efinala) {
		this.efinala = efinala;
	}

	public List<Angajati> getAngajat() {
		return angajat;
	}

	public void setAngajat(List<Angajati> angajat) {
		this.angajat = angajat;
	}
	
	static public List<Angajati> getListProp() {
		return angajat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IDIntern == null) ? 0 : IDIntern.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propuneri other = (Propuneri) obj;
		if (IDIntern == null) {
			if (other.IDIntern != null)
				return false;
		} else if (!IDIntern.equals(other.IDIntern))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Propuneri [IDIntern=" + IDIntern + ", NumeIntern=" + NumeIntern + ", IDPost=" + IDPost + ", NumePost="
				+ NumePost + ", Oferta=" + Oferta + ", efinala=" + efinala + ", angajat=" + angajat + "]";
	}

	
}
