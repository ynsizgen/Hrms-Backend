package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.hrms.entities.abstracts.Entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name = "job_positions")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisements"})
public class JobPosition implements Entities {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "job_position_name")
    private String jobPositionName;
    
    @OneToMany(mappedBy = "jobPosition")
    private List<Advertisement> advertisements;

}
