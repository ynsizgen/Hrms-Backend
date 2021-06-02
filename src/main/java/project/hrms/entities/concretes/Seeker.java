package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.hrms.entities.abstracts.Entities;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "seekers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvs"})
public class Seeker extends User implements Entities {
	
	@Column(name = "first_name", length = 25, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;
	
	@Column(name = "nationality_number", length = 11, nullable = false)
    private String nationalityNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    

    
    @OneToMany(mappedBy = "seeker")
    private List<Cv> cvs;

}
