package project.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Advertisement {
	
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
	
	@CreationTimestamp
	@Column(name = "creationDate")
	private Date creationDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id")
    private Employer employer;
	
    @OneToMany(targetEntity = JobPosition.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   	@JoinColumn(name = "advertisement_id", referencedColumnName = "advertisement_id")
   	private List<JobPosition> jobPositions;
	
    @OneToMany(targetEntity = City.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   	@JoinColumn(name = "advertisement_id", referencedColumnName = "advertisement_id")
   	private List<City> cities;

	
	
	
	


}
