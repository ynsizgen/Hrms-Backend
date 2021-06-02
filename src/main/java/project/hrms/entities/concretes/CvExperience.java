package project.hrms.entities.concretes;

import java.time.LocalDate;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cv_experiences")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvs"})
public class CvExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_experience_id", nullable = false)
	private int cvExperienceId;
	
	@Column(name = "cv_experience_name")
	private String cvExperienceName;
	
	@Column(name = "cv_experience_position")
	private String cvExperiencePosition;
	
	@Column(name = "starting_date")
	private LocalDate startingDate;
	
	@Column(name = "finishing_date")
	private LocalDate finishingDate;
	
//	@OneToMany(mappedBy="cvExperience",fetch = FetchType.LAZY)
//	private List<Cv> cvs;
}
