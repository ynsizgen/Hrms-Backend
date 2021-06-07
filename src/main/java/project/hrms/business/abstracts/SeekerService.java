package project.hrms.business.abstracts;

import java.util.List;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Seeker;



public interface SeekerService {    
    DataResult<List<Seeker>> getAll();
    Result add(Seeker seeker);
    
    DataResult<Seeker> getById(int id);	
}
