package project.hrms.business.abstracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Seeker;

public interface SeekerService {
	
    List<Seeker> addAllSeekers(List<Seeker> seekers);
    
    DataResult<List<Seeker>> getAll();
    Result add(Seeker seeker);
    
    
}
