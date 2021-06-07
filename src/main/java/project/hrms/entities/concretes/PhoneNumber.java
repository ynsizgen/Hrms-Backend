package project.hrms.entities.concretes;



import lombok.Data;

import project.hrms.entities.abstracts.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@Entity
@Table(name = "phone_numbers")

public class PhoneNumber implements Entities{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
    + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
    + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$")
    @NotBlank(message = "This field is required")
    @Column(name = "phone_number")
    private String phoneNumber;
    
    
//    @ManyToOne()
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @JsonIgnore
//    private Employer employer;
}
