package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.concretes.Cv;
import project.hrms.entities.concretes.CvSchool;
import project.hrms.entities.concretes.Seeker;
import project.hrms.entities.dtos.CvSchoolDto;
import project.hrms.entities.dtos.CvWithSeekerDto;

public interface CvService {
	Result add(Cv cv);
	
	DataResult<List<Cv>> getAll();
	
	DataResult<List<CvWithSeekerDto>> getCvWithSeekerDetails();
	
	DataResult<List<Cv>> getBySeekerId(int seekerId);
	
	DataResult<Cv> getByCvId(int cvId);	
}
