package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CvCoverLetter;

public interface CvCoverLetterService {
	Result add(CvCoverLetter coverLetter);
    DataResult<List<CvCoverLetter>> getAll();
    DataResult<CvCoverLetter> getByCvCoverLetterId(int id);	
    public Result delete(CvCoverLetter coverLetter);
    public Result update(CvCoverLetter coverLetter);
    
}
