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


import project.hrms.business.abstracts.CvImageService;

import project.hrms.business.abstracts.SeekerService;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Cv;
import project.hrms.entities.concretes.CvImage;


@RestController
@RequestMapping("/api/images")
public class CvImageController {
	private CvImageService cvImageService;
	
	
	@Autowired
	public CvImageController(CvImageService cvImageService, SeekerService seekerService) {
		super();
		this.cvImageService = cvImageService;
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int cvId, @RequestParam MultipartFile file) {
		CvImage cvImage = new CvImage();
		Cv cv = new Cv();
		cv.setCvId(cvId);
		cvImage.setCv(cv);
	
		
		return this.cvImageService.add(cvImage, file);
	}
	@PostMapping("/update")
	public Result update(@Valid @RequestBody CvImage cvImage){
		return this.cvImageService.update(cvImage);
		
	}
	
	@PostMapping("/delete")
	public Result delete(@Valid @RequestParam int  id){
		return this.cvImageService.delete(id);
		
	}
	
	@GetMapping("/getall")
	public DataResult<List< CvImage>> getAll(){
		return this.cvImageService.getAll();
	}
	

	@GetMapping("/getById")
	public DataResult<CvImage> getByCvId(@RequestParam int cvImageId){
		return this.cvImageService.getByCvImageId(cvImageId);
	}
	
}
