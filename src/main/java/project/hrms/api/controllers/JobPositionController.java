package project.hrms.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.JobPositionService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
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
	
	@PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition){
        return this.jobPositionService.add(jobPosition);
    }
	
	@GetMapping("/getAll")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}	
}
