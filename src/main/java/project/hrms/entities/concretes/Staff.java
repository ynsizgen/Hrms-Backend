package project.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.hrms.entities.abstracts.Entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


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
	
	@NotBlank(message = "This field is required")
	@Size(min = 2, max = 35, message = "Name need to be at least 2 character.")
	@Column(name = "first_name", length = 25, nullable = false)
    private String firstName;
	
	@NotBlank(message = "This field is required")
	@Size(min = 2, max = 35, message = "Surname need to be at least 2 character.")
    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;
     
}
