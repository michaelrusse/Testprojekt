package de.telekom.sea7;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "iban")
public class EntityIBAN {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String iban;
	
	
	public EntityIBAN() {
	}

	public EntityIBAN(long id, String iban) {
		this.id = id;
		this.iban = iban;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@JsonProperty("IBAN")
	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

}
