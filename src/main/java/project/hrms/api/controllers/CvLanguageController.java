package project.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.CvLanguageService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CvLanguage;
import project.hrms.entities.dtos.CvLanguageWithCvDto;

@RestController
@RequestMapping("/api/cvLanguage")
@CrossOrigin
public class CvLanguageController {
	
	private CvLanguageService cvLanguageService;
	
	public CvLanguageController(CvLanguageService cvLanguageService){
		this.cvLanguageService = cvLanguageService;
	}
	
	@PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CvLanguage cvLanguage){
        return ResponseEntity.ok(this.cvLanguageService.add(cvLanguage));
    }
    
    @GetMapping("/getAll")
    public DataResult<List<CvLanguage>> getAll(){
        return this.cvLanguageService.getAll();
    }
    
    
    @GetMapping("/getByCvLanguageId")
    public DataResult<CvLanguage> getByCvLanguageId(@RequestParam int cvLanguageId) {
        return this.cvLanguageService.getByCvLanguageId(cvLanguageId);
    }
    
    
    @PostMapping("/update")
	public ResponseEntity<Result> update(@Valid @RequestBody CvLanguage cvLanguage) {
		Result result = cvLanguageService.update(cvLanguage);

		return ResponseEntity.ok(result);
	}
    
    @DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody CvLanguage cvLanguage) {
		Result result = cvLanguageService.delete(cvLanguage);

		return ResponseEntity.ok(result);
	}
    

    @GetMapping("/getCvLanguageWithCvDetails")
    public DataResult<List<CvLanguageWithCvDto>> getCvLanguageWithCvDetails(@RequestParam int cvId) {
        return this.cvLanguageService.getCvLanguageWithCvDetails(cvId);
    }
    
}
