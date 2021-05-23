package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.hrms.entities.abstracts.Entities;
import java.time.LocalDate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Seekers")
@AllArgsConstructor
@NoArgsConstructor
public class Seeker extends Person implements Entities {
	
	@Column(name = "nationality_id", length = 11, nullable = false)
    private String nationalityId;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

}
