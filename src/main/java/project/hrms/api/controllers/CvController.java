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

import project.hrms.business.abstracts.CvService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Cv;
import project.hrms.entities.dtos.CvWithSeekerDto;

@RestController
@RequestMapping("api/cv")
@CrossOrigin
public class CvController {

	@Autowired
	private CvService cvService;

	@PostMapping("/add")
	public Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@Valid @RequestBody Cv cv) {
		final Result result = cvService.update(cv);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody Cv cv) {
		final Result result = cvService.delete(cv);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getAll")
	public DataResult<List<Cv>> getAll() {
		return this.cvService.getAll();
	}

	@GetMapping("/getCvWithSeekerDetails")
	public DataResult<List<CvWithSeekerDto>> getCvWithSeekerDetails() {
		return this.cvService.getCvWithSeekerDetails();
	}

	@GetMapping("/getBySeekerId")
	public DataResult<List<Cv>> getBySeekerId(@RequestParam int seekerId) {
		return this.cvService.getBySeekerId(seekerId);
	}

	@GetMapping("/getByCvId")
	public DataResult<Cv> getByCvId(@RequestParam int cvId) {
		return this.cvService.getByCvId(cvId);
	}

}
