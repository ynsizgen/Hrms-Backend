package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.EmployerService;
import project.hrms.business.abstracts.UserCheckService;
import project.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {

	private EmployerService employerService;
	private UserCheckService userCheckService;

	@Autowired
	public EmployerController(EmployerService employerService, UserCheckService userCheckService) {
		super();
		this.employerService = employerService;
		this.userCheckService= userCheckService;
	}
	
	@GetMapping("/getAll")
    public List<Employer> getAll(){
        return this.employerService.getAll();
    }
	
	@PostMapping("/addEmployer")
    public ResponseEntity<Employer> addEmployee(@RequestBody Employer employer) throws Exception{
		if(userCheckService.CheckIfRealPerson(employer)) {
			Employer newEmployer = this.employerService.addEmployer(employer);
			return new ResponseEntity<>(newEmployer, HttpStatus.CREATED);
		}else {
			throw new Exception("Not a valid person");
		}
		
		
    }
	
	@PostMapping("/addAllEmployers")
	public ResponseEntity<List<Employer>> addAllEmployers(@RequestBody List<Employer> employers){
		List<Employer> newEmployers = employerService.addAllEmployers(employers);
		return new ResponseEntity<>(newEmployers, HttpStatus.CREATED);
				
	}
	
}
