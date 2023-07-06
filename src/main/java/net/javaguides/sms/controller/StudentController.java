package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import net.javaguides.sms.entity.Student;
import net.javaguides.sms.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	//handler method to handle list of students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());

		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(@ModelAttribute Student student) {


		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@Validated @ModelAttribute("student") Student student, BindingResult res, Model model) {

		if(res.hasErrors()) {
			return createStudentForm(student);
		}

		studentService.saveStudent(student);

		return"redirect:/students";
	}


	//handler method for updating students
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		if( id != null) {
			model.addAttribute("student", studentService.getStudentById(id));
		}

		return "edit_student";

	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @Validated @ModelAttribute("student") Student student, BindingResult res, Model model) {

		//get student from DB by ID
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		if(res.hasErrors()) {

			return editStudentForm(null, model);
		}

		//save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}

	//handler method for student deletion request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";

	}


}


