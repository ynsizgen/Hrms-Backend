package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.Seeker;

public interface SeekerDao extends JpaRepository<Seeker,Integer>  {

}
