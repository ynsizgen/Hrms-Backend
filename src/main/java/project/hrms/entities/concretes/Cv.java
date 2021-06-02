package project.hrms.entities.concretes;



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
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
public class Cv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id", nullable = false)
	private int cvId;
	
	@Column(name = "cv_github")
	private String cvGithub;
	
	@Column(name = "cv_linkedin")
	private String cvLinkedin;
	
	
	@ManyToOne
	@JoinColumn(name = "seeker_id")
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
	
	
	

//	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinColumn(name="cvAbilityId")
//	private CvAbility cvAbility;
//	
//	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinColumn(name="cvCoverLetteId")
//	private CvCoverLetter cvCoverLetter;
//	
//	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinColumn(name="cvExperienceId")
//	private CvExperience cvExperience;
//	
//	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinColumn(name="cvLanguageId")
//    private CvLanguage cvLanguage;
//	
//	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinColumn(name="cvSchoolId")
//    private CvSchool cvSchool;
	


}
