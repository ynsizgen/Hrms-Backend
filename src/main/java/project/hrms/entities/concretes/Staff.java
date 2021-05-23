package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.hrms.entities.abstracts.Entities;

import java.util.List;

import javax.persistence.*;


@Data
@Entity
@Table(name = "staff")
@AllArgsConstructor
@NoArgsConstructor
public class Staff extends Person implements Entities {

    
    @OneToMany(targetEntity = JobPosition.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private List<JobPosition> jobPositions;
    
}
