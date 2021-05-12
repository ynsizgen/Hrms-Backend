package project.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff,Integer> {
    
}
