package com.vijay.online_examination_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vijay.online_examination_system.DTO.StudentDTO;
import com.vijay.online_examination_system.DTO.TeacherDTO;
import com.vijay.online_examination_system.Repository.StudentRepository;
import com.vijay.online_examination_system.Repository.TeacherRepository;
import com.vijay.online_examination_system.model.Student;
import com.vijay.online_examination_system.model.Teacher;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private StudentRepository studentRepository;

	public boolean loginTeacher(TeacherDTO teacherDTO) {
		Teacher teacher = teacherRepository.findByUsername(teacherDTO.getUsername());
		return teacher != null && teacher.getPassword().equals(teacherDTO.getPassword());
	}

	public void registerTeacher(TeacherDTO teacherDTO) {
		Teacher teacher = new Teacher();
		teacher.setUsername(teacherDTO.getUsername());
		teacher.setPassword(teacherDTO.getPassword());
		teacher.setTeacher_role(teacherDTO.getTeacherRole());
		teacherRepository.save(teacher);
	}

	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	public void deleteTeacher(Long id) {
		teacherRepository.deleteById(id);
	}

	public void addStudent(StudentDTO studentDTO) {
		Student student = new Student();

		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());
		student.setPassword(studentDTO.getPassword());
		student.setQualification(studentDTO.getqualification());

		studentRepository.save(student);
	}

	public boolean updateStudent(Long id, StudentDTO studentDTO) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			Student student = optionalStudent.get();

			student.setName(studentDTO.getName());
			student.setEmail(studentDTO.getEmail());
			student.setPassword(studentDTO.getPassword());
			student.setQualification(studentDTO.getqualification());

			studentRepository.save(student);
			return true;
		} else {
			return false;
		}
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}

//@Service
//public class TeacherService {
//
//  private final TeacherRepository teacherRepository;
//  private final StudentRepository studentRepository;
//
//  @Autowired
//  public TeacherService(TeacherRepository teacherRepository, StudentRepository studentRepository) {
//      this.teacherRepository = teacherRepository;
//      this.studentRepository = studentRepository;
//  }
//
//  public void registerTeacher(TeacherDTO teacherDTO) {
//      Teacher teacher = new Teacher();
//      teacher.setUsername(teacherDTO.getUsername());
//      teacher.setPassword(teacherDTO.getPassword());
//      teacherRepository.save(teacher);
//  }
//
//  public boolean loginTeacher(TeacherDTO teacherDTO) {
//    Teacher teacher = teacherRepository.findByUsername(teacherDTO.getUsername());
//    if (teacher != null && teacher.getPassword().equals(teacherDTO.getPassword())) {
//        return true;
//    }
//    return false;
//}
//
//  public List<Teacher> getAllTeachers() {
//      return teacherRepository.findAll();
//  }
//
//  public void deleteTeacher(Long id) {
//      teacherRepository.deleteById(id);
//  }
//
//  public void addStudentWithQualification(StudentDTO studentDTO) {
//      Student student = new Student();
//      student.setName(studentDTO.getName());
//      student.setEmail(studentDTO.getEmail());
//      student.setPassword(studentDTO.getPassword());
//      studentRepository.save(student);
//      studentDTO.setQualification(studentDTO.getQualification());
//      studentRepository.save(student);
//  }
//  public void deleteStudent(String id) {
//      studentRepository.deleteById(id);
//  }
//}