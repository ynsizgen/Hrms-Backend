package project.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.entities.concretes.CvImage;

public interface CvImageService {
	Result add(CvImage cvImage, MultipartFile imageFile);
	Result update(CvImage cvImage);
	Result delete(int id);
	DataResult<CvImage> getByCvImageId(int cvImageId);	
	DataResult<List<CvImage>> getAll();
	
}
