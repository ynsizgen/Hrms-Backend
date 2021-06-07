package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.hrms.entities.abstracts.Entities;


import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;


@Data
@Entity
@Table(name = "job_positions")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition implements Entities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	

    @Column(name = "job_position_name")
    private String jobPositionName;
    
    @JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "advertisement_id", referencedColumnName = "advertisement_id")
    private Advertisement advertisement;

}
