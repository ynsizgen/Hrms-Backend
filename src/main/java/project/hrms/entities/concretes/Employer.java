package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;

import project.hrms.entities.abstracts.Entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employers")

public class Employer extends User implements Entities {

  

    @Column(name = "employer_name", nullable = false)
    private String employerName;

    @Column(name = "employer_website", nullable = false)
    private String website;
    
    @OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<PhoneNumber> phoneNumbers;
    
    
	public Employer() {
		super();
	}

	public Employer(int id, String employerName, String website, List<PhoneNumber> phoneNumbers) {
		super();
		
		this.employerName = employerName;
		this.website = website;
		this.phoneNumbers = phoneNumbers;
	}

	

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	
   
    
   
    
}
