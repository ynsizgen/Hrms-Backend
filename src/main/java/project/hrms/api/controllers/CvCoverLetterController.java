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

import project.hrms.business.abstracts.CvCoverLetterService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CvCoverLetter;


@RestController
@RequestMapping("api/cvCoverLetter")
@CrossOrigin
public class CvCoverLetterController {
	
	@Autowired
	private CvCoverLetterService cvCoverLetterService;
	
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CvCoverLetter cvCoverLetter){
        return ResponseEntity.ok(this.cvCoverLetterService.add(cvCoverLetter));
    }
    
    @GetMapping("/getAll")
    public DataResult<List<CvCoverLetter>> getAll(){
        return this.cvCoverLetterService.getAll();
    }
    
    
    @GetMapping("/getById")
    public DataResult<CvCoverLetter> getById(@RequestParam int cvCoverLetterId) {
        return this.cvCoverLetterService.getByCvCoverLetterId(cvCoverLetterId);
    }
    
    
    @PostMapping("/update")
	public ResponseEntity<Result> update(@Valid @RequestBody CvCoverLetter cvCoverLetter) {
		final Result result = cvCoverLetterService.update(cvCoverLetter);

		return ResponseEntity.ok(result);
	}
    
    @DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody CvCoverLetter cvCoverLetter) {
		final Result result = cvCoverLetterService.delete(cvCoverLetter);

		return ResponseEntity.ok(result);
	}
}
