package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CvExperience;

public interface CvExperienceService {
	Result add(CvExperience coverLetter);
    DataResult<List<CvExperience>> getAll();
    DataResult<CvExperience> getByCvExperienceId(int id);	
    Result delete(CvExperience cvExperience);
    Result update(CvExperience cvExperience);
	DataResult<List<CvExperience>> getAllByOrderByFinishingDateDesc();
}
