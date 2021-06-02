package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.CvSchoolService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.CvSchool;

@RestController
@RequestMapping("api/cvSchool")
public class CvSchoolController {
	
	private CvSchoolService cvSchoolService;
	
	@Autowired
	public CvSchoolController(CvSchoolService cvSchoolService) {
		this.cvSchoolService=cvSchoolService;
	}
	
	@GetMapping("/getAllByOrderByCompletionDateDesc")
	public DataResult<List<CvSchool>> getAllByOrderByCompletionDateDesc(){
		return this.cvSchoolService.getAllByOrderByCompletionDateDesc();
	}
}
