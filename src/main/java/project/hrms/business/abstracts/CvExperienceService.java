package project.hrms.business.abstracts;

import java.util.List;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.entities.concretes.CvExperience;

public interface CvExperienceService {
	DataResult<List<CvExperience>> getAllByOrderByFinishingDateDesc();
}
