package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.hrms.entities.concretes.Employer;

@Repository
public interface EmployorDao extends JpaRepository<Employer, Integer>{

}
