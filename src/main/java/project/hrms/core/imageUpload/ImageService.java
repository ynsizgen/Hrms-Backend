package project.hrms.core.imageUpload;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import project.hrms.core.utilities.results.DataResult;

public interface ImageService {
	DataResult<Map> save(MultipartFile imageFile);

}