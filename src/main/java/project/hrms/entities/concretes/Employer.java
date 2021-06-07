package project.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.hrms.entities.abstracts.Entities;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisements"})
public class Employer extends User implements Entities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@NotBlank(message = "This field is required")
	@Size(min = 5, max = 35, message = "Name need to be at least 5 character.")
	@NotBlank(message = "This field is required")
    @Column(name = "employer_name")
    private String employerName;
	
	@NotBlank(message = "This field is required")
    @Column(name = "employer_website")
    private String website;
	
	@NotBlank(message = "This field is required")
    @Column(name = "employer_phone_number")
    private String phoneNumber;
    
    @JsonIgnore
    @OneToMany(targetEntity = Advertisement.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   	@JoinColumn(name = "id", referencedColumnName = "id")
   	private List<Advertisement> advertisements;
    
}
