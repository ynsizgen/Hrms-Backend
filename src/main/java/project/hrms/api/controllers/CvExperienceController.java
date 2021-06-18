package project.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.CvExperienceService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CvExperience;


@RestController
@RequestMapping("api/cvExperience")
@CrossOrigin
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
	
	@PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CvExperience cvExperience){
        return ResponseEntity.ok(this.cvExperienceService.add(cvExperience));
    }
    
    @GetMapping("/getAll")
    public DataResult<List<CvExperience>> getAll(){
        return this.cvExperienceService.getAll();
    }
    
    
    @GetMapping("/getById")
    public DataResult<CvExperience> getById(@RequestParam int cvExperienceId) {
        return this.cvExperienceService.getByCvExperienceId(cvExperienceId);
    }
    
    
    @PostMapping("/update")
	public ResponseEntity<Result> update(@Valid @RequestBody CvExperience cvExperience) {
		final Result result = cvExperienceService.update(cvExperience);

		return ResponseEntity.ok(result);
	}
    
    @DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody  CvExperience cvExperience) {
		final Result result = cvExperienceService.delete(cvExperience);

		return ResponseEntity.ok(result);
	}
	
	
}
