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
public class Staff implements Entities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",nullable = false, updatable = false)
	private int id;
	
	@Column(name = "first_name", length = 25, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;
    
    
}
