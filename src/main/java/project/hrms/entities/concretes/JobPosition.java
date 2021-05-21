package project.hrms.entities.concretes;

import lombok.Data;
import project.hrms.entities.abstracts.Entities;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_positions")

public class JobPosition implements Entities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "job_position_name", nullable = false)
    private String jobPositionName;

}
