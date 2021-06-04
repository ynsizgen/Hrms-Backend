package project.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.hrms.entities.abstracts.Entities;

@Data
@Entity
@Table(name = "advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement implements Entities{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "advertisement_id")
	private int advertisementId;
	
	@Column(name = "description_entry")
	private String description;
	
	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@Column(name = "amount_of_positions")
	private int amountOfPositions;
	
	@Column(name = "deadline")
	private LocalDate deadline;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "creationDate")
	private LocalDate creationDate;
	
	
	@ManyToOne
	@JoinColumn(name = "job_position_id", nullable = false)
	private JobPosition jobPosition;
	
	@ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

	@ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

}
