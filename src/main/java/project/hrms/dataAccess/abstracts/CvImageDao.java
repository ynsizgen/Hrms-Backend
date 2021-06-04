package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import project.hrms.entities.concretes.CvImage;

public interface CvImageDao extends JpaRepository<CvImage, Integer>{
	CvImage getByCvImageId(int cvImageId);

}
