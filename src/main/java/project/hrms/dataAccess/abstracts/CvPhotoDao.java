package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.CvPhoto;

public interface CvPhotoDao extends JpaRepository<CvPhoto, Integer>{
	CvPhoto getByCvPhotoId(int cvPhotoId);

}
