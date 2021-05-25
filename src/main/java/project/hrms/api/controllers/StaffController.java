package project.hrms.api.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import project.hrms.business.abstracts.StaffService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
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
	public DataResult<List<Staff>> getAll(){
		return this.staffService.getAll();
	}
	
	@PostMapping("/add")
    public Result add(@RequestBody Staff staff){
        return this.staffService.add(staff);
    }
	
	
}
