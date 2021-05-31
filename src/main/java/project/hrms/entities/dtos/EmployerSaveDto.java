package project.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.hrms.entities.concretes.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerSaveDto extends User{
	
    private String employerName;
    private String website;
}
