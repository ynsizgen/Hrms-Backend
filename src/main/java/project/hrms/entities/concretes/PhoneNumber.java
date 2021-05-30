package project.hrms.entities.concretes;



import lombok.Data;

import project.hrms.entities.abstracts.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    
    
//    @ManyToOne()
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @JsonIgnore
//    private Employer employer;
}
