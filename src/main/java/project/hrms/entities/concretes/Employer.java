package project.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.hrms.entities.abstracts.Entities;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisements"})
public class Employer extends User implements Entities {

	@NotEmpty(message = "Soyisim bos birakilamaz.")
	@Size(min=2, max=30)
    @Column(name = "employer_name")
    private String employerName;

    @Column(name = "employer_website")
    private String website;
    
    @OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "employer_id", referencedColumnName = "id")
    private List<PhoneNumber> phoneNumbers;
    
//    @OneToMany( mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = false)
//    //@JoinColumn(referencedColumnName = "id")
//    private List<PhoneNumber> phoneNumbers;
    
    @OneToMany(mappedBy = "employer")
    private List<Advertisement> advertisements;

}
