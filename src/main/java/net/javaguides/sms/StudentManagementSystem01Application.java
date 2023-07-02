package net.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystem01Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystem01Application.class, args);
	}

	//executes when running this spring app(default student records in database)
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {

		/*
		 * Student student1 = new Student("John", "Hawkin", "JHawkin@gmail.com");
		 * studentRepository.save(student1);
		 *
		 * Student student2 = new Student("Mike", "Gorwin", "MGorwin@gmail.com");
		 * studentRepository.save(student2);
		 *
		 * Student student3 = new Student("Peter", "Wande", "PWande@gmail.com");
		 * studentRepository.save(student3);
		 */

	}



}
