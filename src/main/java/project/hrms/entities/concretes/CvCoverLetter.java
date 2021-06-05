package project.hrms.entities.concretes;


import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cv_cover_letters")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvs"})
public class CvCoverLetter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_cover_letter_id", nullable = false)
	private int cvCoverLetterId;
	
	@Column(name = "cv_cover_letter_name")
	private String cvCoverLetterName;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
    private Cv cv;
	
	

}
