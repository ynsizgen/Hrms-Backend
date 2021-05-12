package project.hrms.entities.concretes;

import lombok.Data;
import project.hrms.entities.abstracts.Entities;

import javax.persistence.*;

@Entity
@Data
@Table(name = "job_positions")
public class JobPosition implements Entities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "job_position_name", nullable = false)
    private String jobPositionName;
    
	public JobPosition() {
		super();
	}
	public JobPosition(int id, String jobPositionName) {
		super();
		this.id = id;
		this.jobPositionName = jobPositionName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getJobPositionName() {
		return jobPositionName;
	}


	public void setJobPositionName(String jobPositionName) {
		this.jobPositionName = jobPositionName;
	}

   
}
