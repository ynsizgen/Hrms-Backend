package project.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.hrms.entities.abstracts.Entities;

import javax.persistence.*;

@Data
@Entity
@Table(name = "phone_numbers")
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber implements Entities{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "phone_number")
    private String phoneNumber;
    
    

	public PhoneNumber() {
		super();
	}

	public PhoneNumber(int id, String phoneNumber) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
    
}
