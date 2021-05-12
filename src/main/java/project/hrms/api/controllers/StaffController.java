package project.hrms.api.controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import project.hrms.business.abstracts.StaffService;
import project.hrms.entities.concretes.Staff;


@RestController
@RequestMapping("/api/staff")
public class StaffController {
	
	private StaffService staffService;

	public StaffController(StaffService staffService) {
		super();
		this.staffService = staffService;
	}

	@GetMapping("/getAll")
	public List<Staff> getAll(){
		return this.staffService.getAll();
	}
	
	@PostMapping("/addStaff")
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff){
        Staff newStaff = staffService.addStaff(staff);
        return new ResponseEntity<>(newStaff, HttpStatus.CREATED);
    }
	
	
}
