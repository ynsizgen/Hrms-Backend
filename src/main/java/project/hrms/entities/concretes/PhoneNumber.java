package project.hrms.entities.concretes;



import lombok.Data;

import project.hrms.entities.abstracts.Entities;

import javax.persistence.*;

@Data
@Entity
@Table(name = "phone_numbers")

public class PhoneNumber implements Entities{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "phone_number")
    private String phoneNumber;
    
    
}
