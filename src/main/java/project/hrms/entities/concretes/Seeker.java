package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.hrms.entities.abstracts.Entities;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "seekers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvs"})
public class Seeker extends User implements Entities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@NotBlank(message = "This field is required")
	@Size(min = 2, max = 35, message = "Name need to be at least 2 character.")
	@Column(name = "first_name", nullable = false)
    private String firstName;

	@NotBlank(message = "This field is required")
	@Size(min = 2, max = 35, message = "Surname need to be at least 2 character.")
    @Column(name = "last_name", nullable = false)
    private String lastName;

	@NotBlank(message = "This field is required")
    @Column(name = "employer_phone_number")
    private String phoneNumber;
	
	@NotBlank(message = "This field is required")
	@Size(min=11, max=11, message = "Identity number was entered missing.")
	@Column(name = "nationality_number", nullable = false)
    private String nationalityNumber;
	
	@NotNull(message = "This field is required")
	@Past(message = "Date input is invalid for a birth date.")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    
    @JsonIgnore
    @OneToMany(targetEntity = Cv.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private List<Cv> cvs;


}
