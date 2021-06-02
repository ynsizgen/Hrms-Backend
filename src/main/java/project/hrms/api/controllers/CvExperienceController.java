package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.CvExperienceService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.CvExperience;


@RestController
@RequestMapping("api/cvExperience")
public class CvExperienceController {
	
	private CvExperienceService cvExperienceService;
	
	@Autowired
	public CvExperienceController(CvExperienceService cvExperienceService) {
		this.cvExperienceService=cvExperienceService;
	}
	
	@GetMapping("/getAllByOrderByFinishingDateDesc")
	public DataResult<List<CvExperience>> getAllByOrderByFinishingDateDesc(){
		return this.cvExperienceService.getAllByOrderByFinishingDateDesc();
	}
}
