package in.lakshay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.lakshay.entity.Student;  

public interface StudentRepository  
	extends JpaRepository<Student, Long>
{

	@Modifying
	@Query("UPDATE Student SET studentName=:sname WHERE studentId=:sid")  
	int updateStudentName(String sname, Long sid);  
}
