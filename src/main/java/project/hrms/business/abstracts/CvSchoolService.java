package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CvSchool;

public interface CvSchoolService {
	
	Result add(CvSchool cvSchool);
    DataResult<List<CvSchool>> getAll();
    DataResult<CvSchool> getByCvSchoolId(int id);	
    Result delete(CvSchool cvSchool);
    Result update(CvSchool cvSchool);
	DataResult<List<CvSchool>> getAllByOrderByCompletionDateDesc();
}
