package project.hrms.business.concretes;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.hrms.business.abstracts.CvPhotoService;
import project.hrms.core.imageUpload.ImageService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvPhotoDao;
import project.hrms.entities.concretes.CvPhoto;

@Service
public class CvPhotoManager implements CvPhotoService{


	private CvPhotoDao cvPhotoDao;
	private ImageService imageService;
	
	@Autowired
	public CvPhotoManager(CvPhotoDao cvPhotoDao,ImageService imageService) {
		super();
		this.cvPhotoDao = cvPhotoDao;
		this.imageService = imageService;
	}

	
	@Override
	public Result add(CvPhoto cvPhoto,MultipartFile imageFile) {
		Map<String, String> result = (Map<String, String>) this.imageService.save(imageFile).getData();
		String url = result.get("url");
		cvPhoto.setUrlAddress(url);
		
		return new SuccessDataResult<CvPhoto>(this.cvPhotoDao.save(cvPhoto),"photo added");
	}

	@Override
	public Result update(CvPhoto cvPhoto) {
		this.cvPhotoDao.save(cvPhoto);
		return new SuccessResult("Photo updated!");
	}

	@Override
	public Result delete(int id) {
		this.cvPhotoDao.deleteById(id);
		return new SuccessResult("photo deleted");
	}

	@Override
	public DataResult<CvPhoto>getByCvImageId(int cvPhotoId) {
		return new SuccessDataResult<CvPhoto>(this.cvPhotoDao.getByCvPhotoId(cvPhotoId));
		
	}

	@Override
	public DataResult<List<CvPhoto>> getAll() {
		return new SuccessDataResult<List<CvPhoto>>(this.cvPhotoDao.findAll());		
	}




}
