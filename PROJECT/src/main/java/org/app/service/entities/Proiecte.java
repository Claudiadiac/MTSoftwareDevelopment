package org.app.service.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.ALL;

@Entity
public class Proiecte {
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer IDProiect;
	private String NumeProiect;
	private Integer IDCoordonator;
	private String NumeCoordonator;
	
	@OneToMany(mappedBy="proiect", cascade = ALL, fetch = FetchType.EAGER)
	static private List<Intern> interni = new ArrayList<>();

	public Proiecte(Integer iDProiect, String numeProiect, Integer iDCoordonator, String numeCoordonator,
			List<Intern> interni) {
		super();
		IDProiect = iDProiect;
		NumeProiect = numeProiect;
		IDCoordonator = iDCoordonator;
		NumeCoordonator = numeCoordonator;
		this.interni = interni;
	}

	public Proiecte() {
		super();
	}

	public Integer getIDProiect() {
		return IDProiect;
	}

	public void setIDProiect(Integer iDProiect) {
		IDProiect = iDProiect;
	}

	public String getNumeProiect() {
		return NumeProiect;
	}

	public void setNumeProiect(String numeProiect) {
		NumeProiect = numeProiect;
	}

	public Integer getIDCoordonator() {
		return IDCoordonator;
	}

	public void setIDCoordonator(Integer iDCoordonator) {
		IDCoordonator = iDCoordonator;
	}

	public String getNumeCoordonator() {
		return NumeCoordonator;
	}

	public void setNumeCoordonator(String numeCoordonator) {
		NumeCoordonator = numeCoordonator;
	}

	public List<Intern> getInterni() {
		return interni;
	}

	public void setInterni(List<Intern> interni) {
		this.interni = interni;
	}
	static public List<Intern> getListInter() {
		return interni;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IDProiect == null) ? 0 : IDProiect.hashCode());
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
		Proiecte other = (Proiecte) obj;
		if (IDProiect == null) {
			if (other.IDProiect != null)
				return false;
		} else if (!IDProiect.equals(other.IDProiect))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proiecte [IDProiect=" + IDProiect + ", NumeProiect=" + NumeProiect + ", IDCoordonator=" + IDCoordonator
				+ ", NumeCoordonator=" + NumeCoordonator + ", interni=" + interni + "]";
	}

	
}
