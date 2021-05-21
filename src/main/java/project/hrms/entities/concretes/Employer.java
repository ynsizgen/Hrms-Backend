package project.hrms.entities.concretes;


import lombok.Data;


import project.hrms.entities.abstracts.Entities;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Employers")
public class Employer extends User implements Entities {

	
    @Column(name = "employer_name", nullable = false)
    private String employerName;

    @Column(name = "employer_website", nullable = false)
    private String website;
    
    @OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<PhoneNumber> phoneNumbers;
    

}
