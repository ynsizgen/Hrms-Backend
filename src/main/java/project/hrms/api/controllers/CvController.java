package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.CvService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.concretes.Cv;

import project.hrms.entities.dtos.CvWithSeekerDto;

@RestController
@RequestMapping("api/cv")
public class CvController {
	
	@Autowired
	private CvService cvService;
	
	@PostMapping("/add")
	public Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}
	
	@GetMapping("/getAll")
    public DataResult<List<Cv>> getAll(){
        return this.cvService.getAll();
    }
	
	@GetMapping("/getAdvertisementWithEmployerDetails")
	public DataResult<List<CvWithSeekerDto>> getAdvertisementWithEmployerDetails(){
		return this.cvService.getCvWithSeekerDetails();
	}
	
	@GetMapping("/getBySeekerId")
    public DataResult<List<Cv>> getBySeekerId(@RequestParam int seekerId) {
        return this.cvService.getBySeekerId(seekerId);
    }
	
	
}
