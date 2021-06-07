package project.hrms.api.controllers;



import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import project.hrms.business.abstracts.CvPhotoService;
import project.hrms.business.abstracts.SeekerService;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Cv;
import project.hrms.entities.concretes.CvPhoto;


@RestController
@RequestMapping("/api/images")
public class CvPhotoController {
	private CvPhotoService cvPhotoService;
	
	
	@Autowired
	public CvPhotoController(CvPhotoService cvPhotoService, SeekerService seekerService) {
		super();
		this.cvPhotoService = cvPhotoService;
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int cvId, @RequestParam MultipartFile file) {
		CvPhoto cvPhoto = new CvPhoto();
		Cv cv = new Cv();
		cv.setCvId(cvId);
		cvPhoto.setCv(cv);
		
		return this.cvPhotoService.add(cvPhoto, file);
	}
	@PostMapping("/update")
	public Result update(@Valid @RequestBody CvPhoto cvPhoto){
		return this.cvPhotoService.update(cvPhoto);
		
	}
	
	@PostMapping("/delete")
	public Result delete(@Valid @RequestParam int  id){
		return this.cvPhotoService.delete(id);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List< CvPhoto>> getAll(){
		return this.cvPhotoService.getAll();
	}
	

	@GetMapping("/getById")
	public DataResult<CvPhoto> getByCvId(@RequestParam int cvImageId){
		return this.cvPhotoService.getByCvImageId(cvImageId);
	}
	
	
}
