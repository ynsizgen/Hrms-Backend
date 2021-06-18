package project.hrms.business.abstracts;

import java.util.List;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.Seeker;



public interface SeekerService {   

	Result add(Seeker seeker);
    DataResult<List<Seeker>> getAll();
    DataResult<Seeker> getById(int id);	
    public Result delete(Seeker seeker);
    public Result update(Seeker seeker);
}
