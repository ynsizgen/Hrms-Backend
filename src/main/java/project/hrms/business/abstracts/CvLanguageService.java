package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;

import project.hrms.entities.concretes.CvLanguage;

import project.hrms.entities.dtos.CvLanguageWithCvDto;

public interface CvLanguageService {
	Result add(CvLanguage cvLanguage);
    DataResult<List<CvLanguage>> getAll();
    DataResult<CvLanguage> getByCvLanguageId(int id);	
    Result delete(CvLanguage cvLanguage);
    Result update(CvLanguage cvLanguage);
    
    DataResult<List<CvLanguageWithCvDto>> getCvLanguageWithCvDetails(int cvId);
    
}
