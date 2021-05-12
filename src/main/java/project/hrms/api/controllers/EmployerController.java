package project.hrms.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hrms.business.abstracts.EmployerService;
import project.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/Employer")
public class EmployerController {

	private EmployerService employerService;

	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@PostMapping("/addEmployer")
    public ResponseEntity<Employer> addEmployer(@RequestBody Employer employer){
        Employer newEmployer = employerService.addEmployer(employer);
        return new ResponseEntity<>(newEmployer, HttpStatus.CREATED);
    }
	
	@PostMapping("/addAllEmployers")
	public ResponseEntity<List<Employer>> addAllEmployers(@RequestBody List<Employer> employers){
		List<Employer> newEmployers = employerService.addAllEmployers(employers);
		return new ResponseEntity<>(newEmployers, HttpStatus.CREATED);
				
	}
	
}
