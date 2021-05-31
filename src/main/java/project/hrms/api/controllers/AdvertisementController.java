package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.AdvertisementService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Advertisement;
import project.hrms.entities.dtos.AdvertisementWithEmployerDto;



@RestController
@RequestMapping("api/advertisemenent")
public class AdvertisementController {
	
	private AdvertisementService advertisementService;
	
	@Autowired
	public AdvertisementController(AdvertisementService advertisementService) {
		super();
		this.advertisementService = advertisementService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Advertisement advertisement) {
		return this.advertisementService.add(advertisement);
	}
	
	@GetMapping("/getAll")
    public DataResult<List<Advertisement>> getAll(){
        return this.advertisementService.getAll();
    }
	
	@GetMapping("/getByEmployerId")
    public DataResult<List<Advertisement>> getByEmployerId(@RequestParam int employerId) {
        return this.advertisementService.getByEmployerId(employerId);
    }
	
	@GetMapping("/changeStatus")
	public Result changeStatus(@RequestParam int advertisementId,@RequestParam boolean status) {
		return this.advertisementService.changeStatus(advertisementId, status);	
	}
	
	@GetMapping("/getByStatusTrue")
    public DataResult<List<Advertisement>> getByStatusTrue(){
        return this.advertisementService.getByStatusTrue();
    }
	
	
	@GetMapping("/getByStatusTrueOrderByCreationDate")
	public DataResult<List<Advertisement>> getByStatusTrueOrderByCreationDate(){
		return this.advertisementService.getByStatusTrueOrderByCreationDate();
	}
	
	@GetMapping("/getByStatusTrueAndEmployerId")
	public DataResult<List<Advertisement>> getByStatusTrueAndEmployerId(@RequestParam int employerId){
		return this.advertisementService.getByStatusTrueAndEmployerId(employerId);	
	}

	
	@GetMapping("/getAdvertisementIdByIdAndEmployerId")
	public Result  getByIdAndEmployerId(@RequestParam int advertisementId ,@RequestParam int employerId){
		return this.advertisementService.getByAdvertisementIdAndEmployerId(advertisementId, employerId);	
	}
	
	@GetMapping("/getAdvertisementWithEmployerDetails")
	public DataResult<List<AdvertisementWithEmployerDto>> getAdvertisementWithEmployerDetails(){
		return this.advertisementService.getAdvertisementWithEmployerDetails();
	}
	
}
	
	
	
	

