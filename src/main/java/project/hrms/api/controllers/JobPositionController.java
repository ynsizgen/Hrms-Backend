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

import project.hrms.business.abstracts.JobPositionService;
import project.hrms.entities.concretes.JobPosition;


@RestController
@RequestMapping("/api/jobPosition")
public class JobPositionController {
	
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@PostMapping("/addJobPosition")
    public ResponseEntity<JobPosition> addJobPosition(@RequestBody JobPosition jobPosition){
        JobPosition newJobPosition = jobPositionService.addJobPosition(jobPosition);
        return new ResponseEntity<>(newJobPosition, HttpStatus.CREATED);
    }
	
	@GetMapping("/getAll")
	public List<JobPosition> getAll(){
		return this.jobPositionService.getAll();
	}	
}
