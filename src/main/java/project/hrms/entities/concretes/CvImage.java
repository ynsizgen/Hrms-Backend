package project.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cv_image")
@AllArgsConstructor
@NoArgsConstructor
public class CvImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_image_id", nullable = false)
	private int cvImageId;
	
	@Column(name = "url_address")
	private String urlAddress;
	
	
	@JsonIgnore
	@OneToOne(optional=false,fetch=FetchType.LAZY)
    @JoinColumn(name = "cv_id", referencedColumnName = "cv_id")
    private Cv cv;

}
