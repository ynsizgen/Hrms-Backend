package project.hrms.entities.concretes;

import lombok.Data;
import project.hrms.entities.abstracts.Entities;
import javax.persistence.*;

@Entity
@Data
@Table(name = "Seekers")
public class Seeker implements Entities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "seeker_identification_number", nullable = false, updatable = false, unique = true)
    private String identificationNumber;

    @Column(name = "seeker_name", nullable = false)
    private String seekerName;

    @Column(name = "seeker_surname", nullable = false)
    private String seekerSurname;

    @Column(name = "seeker_password", nullable = false)
    private String seekerPassword;

    
    
	public Seeker() {
		
	}

	public Seeker(int id, String identificationNumber, String seekerName, String seekerSurname, String seekerPassword) {
		
		this.id = id;
		this.identificationNumber = identificationNumber;
		this.seekerName = seekerName;
		this.seekerSurname = seekerSurname;
		this.seekerPassword = seekerPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getSeekerName() {
		return seekerName;
	}

	public void setSeekerName(String seekerName) {
		this.seekerName = seekerName;
	}

	public String getSeekerSurname() {
		return seekerSurname;
	}

	public void setSeekerSurname(String seekerSurname) {
		this.seekerSurname = seekerSurname;
	}

	public String getSeekerPassword() {
		return seekerPassword;
	}

	public void setSeekerPassword(String seekerPassword) {
		this.seekerPassword = seekerPassword;
	}
	
	
    
}
