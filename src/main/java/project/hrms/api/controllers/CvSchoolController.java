package project.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.CvSchoolService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CvSchool;

@RestController
@RequestMapping("api/cvSchool")
public class CvSchoolController {

	private CvSchoolService cvSchoolService;

	@Autowired
	public CvSchoolController(CvSchoolService cvSchoolService) {
		this.cvSchoolService = cvSchoolService;
	}

	@GetMapping("/getAllByOrderByCompletionDateDesc")
	public DataResult<List<CvSchool>> getAllByOrderByCompletionDateDesc() {
		return this.cvSchoolService.getAllByOrderByCompletionDateDesc();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CvSchool cvSchool) {
		return ResponseEntity.ok(this.cvSchoolService.add(cvSchool));
	}

	@GetMapping("/getAll")
	public DataResult<List<CvSchool>> getAll() {
		return this.cvSchoolService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<CvSchool> getByCvSchoolId(@RequestParam int cvSchoolId) {
		return this.cvSchoolService.getByCvSchoolId(cvSchoolId);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@Valid @RequestBody CvSchool cvSchool) {
		final Result result = cvSchoolService.update(cvSchool);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody CvSchool cvSchool) {
		final Result result = cvSchoolService.delete(cvSchool);

		return ResponseEntity.ok(result);
	}

}
