package project.hrms.entities.concretes;

import lombok.Data;
import project.hrms.entities.abstracts.Entities;

import java.util.List;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Staff")
public class Staff extends Person implements Entities {

    
    @OneToMany(targetEntity = JobPosition.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private List<JobPosition> jobPositions;
    
}
