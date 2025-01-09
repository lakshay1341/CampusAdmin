package in.lakshay.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.lakshay.entity.Student;
import in.lakshay.exception.StudentNotFoundException;
import in.lakshay.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

	@Autowired
	private IStudentService service;

	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
		Long id = service.createStudent(student);
		String message = "Student '"+id+"' created!";
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> findAllStudents() {
		List<Student> list = service.findAllStudents();
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findOneStudent(@PathVariable Long id) {
		ResponseEntity<?> resp = null;
		try {
			Student student =  service.findOneStudent(id);
			resp = new ResponseEntity<Student>(student,HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return resp;
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		ResponseEntity<String> resp = null;
		try {
			service.deleteOneStudent(id);
			resp = new ResponseEntity<String>("Student Deleted",HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return resp;
	}
 	
	@PutMapping("/modify")
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		ResponseEntity<String> response = null;
		try {
			service.updateStudent(student);
			response = new ResponseEntity<String>("Student Updated!",HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
	
	@PatchMapping("/modify/name/{id}/{name}")
	public ResponseEntity<String> updateStudentName(@PathVariable Long id, @PathVariable String name) {
		ResponseEntity<String> response = null;
		try {
			service.updateStudentName(name, id);
			response = new ResponseEntity<String>("Student Name Updated!",HttpStatus.OK);
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
}
