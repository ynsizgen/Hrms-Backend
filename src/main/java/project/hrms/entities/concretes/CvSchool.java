package project.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cv_schools")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class CvSchool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_school_id", nullable = false )
	private int cvSchoolId;
	
	@NotBlank(message = "This field is required")
	@Column(name = "cv_school_name")
	private String cvSchoolName;
	
	@NotBlank(message = "This field is required")
	@Column(name = "cv_school_department")
	private String cvSchoolDepartment;
	
	@NotBlank(message = "This field is required")
	@Column(name = "admission_date")
	private LocalDate admissionDate;
	
	@NotBlank(message = "This field is required")
	@Column(name = "completion_date")
	private LocalDate completionDate; 
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
    private Cv cv;
}
