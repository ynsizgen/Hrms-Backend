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
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id", nullable = false)
	private int cvId;
	
	
	@Column(name= "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	
	@Column(name= "created_date")
	private LocalDate creationDate = LocalDate.now();
	
	@Column(name = "cv_github")
	private String cvGithub;
	
	@Column(name = "cv_linkedin")
	private String cvLinkedin;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id")
    private Seeker seeker;
	
	
	
	@OneToMany(targetEntity = CvAbility.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
	private List<CvAbility> cvAbilities;

	@OneToMany(targetEntity = CvCoverLetter.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
    private List<CvCoverLetter> cvCoverLetters;
	
	@OneToMany(targetEntity = CvExperience.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
    private List<CvExperience> cvExperiences;
	
	@OneToMany(targetEntity = CvLanguage.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
    private List<CvLanguage> cvLanguages;
	
	@OneToMany(targetEntity = CvSchool.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
    private List<CvSchool> CvSchools;
	
	@OneToOne(targetEntity = CvPhoto.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
    private CvPhoto cvPhoto;
	
	


}
