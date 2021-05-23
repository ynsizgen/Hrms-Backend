package project.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "Persons")
@AllArgsConstructor
@NoArgsConstructor
public class Person extends User{

    @Column(name = "first_name", length = 25, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;
    
  
    
    
}