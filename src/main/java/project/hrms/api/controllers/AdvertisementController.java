package project.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project.hrms.business.abstracts.AdvertisementService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Advertisement;
import project.hrms.entities.dtos.AdvertisementWithEmployerDto;



@RestController
@RequestMapping("api/advertisemenent")
@CrossOrigin
public class AdvertisementController {
	
	private AdvertisementService advertisementService;
	
	@Autowired
	public AdvertisementController(AdvertisementService advertisementService) {
		super();
		this.advertisementService = advertisementService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Advertisement advertisement) {
		return ResponseEntity.ok(this.advertisementService.add(advertisement));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Result> update(@Valid @RequestBody Advertisement advertisement) {
		final Result result = advertisementService.update(advertisement);

		return ResponseEntity.ok(result);
	}
    
    @DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody Advertisement advertisement) {
		final Result result = advertisementService.delete(advertisement);

		return ResponseEntity.ok(result);
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        
    }
	
}
	
	
	
	

