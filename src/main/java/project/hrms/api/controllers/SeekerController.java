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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import project.hrms.business.abstracts.SeekerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.ErrorDataResult;
import project.hrms.entities.concretes.Seeker;


@RestController
@RequestMapping("/api/seekers")
public class SeekerController {

    private SeekerService seekerService;

    @Autowired
    public SeekerController(SeekerService seekerService) {
    	super();
        this.seekerService = seekerService;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Seeker seeker){
        return ResponseEntity.ok(this.seekerService.add(seeker));
    }
    
    @GetMapping("/getAll")
    public DataResult<List<Seeker>> getAll(){
        return this.seekerService.getAll();
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
