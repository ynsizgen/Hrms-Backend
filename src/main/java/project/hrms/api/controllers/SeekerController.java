package project.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.hrms.business.abstracts.SeekerService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
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
    public Result add(@RequestBody Seeker seeker){
        return this.seekerService.add(seeker);
    }
    
    @GetMapping("/getAll")
    public DataResult<List<Seeker>> getAll(){
        return this.seekerService.getAll();
    }

    
        
}
