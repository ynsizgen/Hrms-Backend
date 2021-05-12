package project.hrms.entities.concretes;

import lombok.Data;
import project.hrms.entities.abstracts.Entities;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employers")
public class Employer implements Entities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private int id;

    @Column(name = "employer_name", nullable = false)
    private String employerName;
    
    @Column(name = "employer_password", nullable = false)
    private String password;
    
    @Column(name = "employer_phone", nullable = false)
    private String phoneNumber;

    @Column(name = "employer_website", nullable = false)
    private String website;


	public Employer() {	
	
	}

	public Employer(int id, String employerName, String password, String phoneNumber, String website) {
		
		this.id = id;
		this.employerName = employerName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.website = website;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
    
    
   
    
}
