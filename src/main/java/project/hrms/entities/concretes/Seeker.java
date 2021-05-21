package project.hrms.entities.concretes;

import lombok.Data;
import project.hrms.entities.abstracts.Entities;
import java.time.LocalDate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Seekers")
public class Seeker extends Person implements Entities {
	@Column(name = "nationaly_id", length = 11, unique = true, nullable = false)
    private String nationalityId;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

}
