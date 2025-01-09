package in.lakshay.service;

import java.util.List;

import in.lakshay.entity.Student;  

public interface IStudentService {  

	Long createStudent(Student student);  
	List<Student> findAllStudents();  
	Student findOneStudent(Long id);  
	void deleteOneStudent(Long id);  
	void updateStudent(Student student); 
	int updateStudentName(String sname, Long sid); 
}

