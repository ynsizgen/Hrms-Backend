package project.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.hrms.business.abstracts.CvImageService;
import project.hrms.core.imageUpload.ImageService;
import project.hrms.core.utilities.results.DataResult;
import project.hrms.core.utilities.results.Result;
import project.hrms.core.utilities.results.SuccessDataResult;
import project.hrms.core.utilities.results.SuccessResult;
import project.hrms.dataAccess.abstracts.CvImageDao;
import project.hrms.entities.concretes.CvImage;

@Service
public class CvImageManager implements CvImageService{


	private CvImageDao cvImageDao;
	private ImageService imageService;
	
	@Autowired
	public CvImageManager(CvImageDao cvImageDao,ImageService imageService) {
		super();
		this.cvImageDao = cvImageDao;
		this.imageService = imageService;
	}

	
	@Override
	public Result add(CvImage cvImage,MultipartFile imageFile) {
		Map<String, String> result = (Map<String, String>) this.imageService.save(imageFile).getData();
		String url = result.get("url");
		cvImage.setUrlAddress(url);
		
		return new SuccessDataResult<CvImage>(this.cvImageDao.save(cvImage),"Image added");
	}

	@Override
	public Result update(CvImage cvImage) {
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Fotoğraf güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.cvImageDao.deleteById(id);
		return new SuccessResult("image deleted");
	}

	@Override
	public DataResult<CvImage>getByCvImageId(int cvImageId) {
		return new SuccessDataResult<CvImage>(this.cvImageDao.getByCvImageId(cvImageId));
		
	}

	@Override
	public DataResult<List<CvImage>> getAll() {
		return new SuccessDataResult<List<CvImage>>(this.cvImageDao.findAll());		
	}




}
