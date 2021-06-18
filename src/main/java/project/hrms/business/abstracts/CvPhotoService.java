package project.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CvPhoto;

public interface CvPhotoService {
	Result add(CvPhoto cvPhoto, MultipartFile imageFile);
	Result update(CvPhoto cvPhoto);
	Result delete(CvPhoto cvPhoto);
	DataResult<CvPhoto> getByCvImageId(int cvImageId);	
	DataResult<List<CvPhoto>> getAll();
	
}
