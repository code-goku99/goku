package deepu.proj.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pubId;
	private String name;
	
	/**
	 * 
	 */
	public Publisher() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 */
	public Publisher(String name) {
		super();
		this.name = name;
	}
	public Long getPubId() {
		return pubId;
	}
	public void setPubId(Long pubId) {
		this.pubId = pubId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
