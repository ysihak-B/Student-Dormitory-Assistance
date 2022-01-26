package com.sda.student_dormitory_assistant;

import com.sda.student_dormitory_assistant.security.User;
import com.sda.student_dormitory_assistant.security.UserRepository;
import com.sda.student_dormitory_assistant.security.User.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class StudentDormitoryAssistantApplication implements CommandLineRunner {
		@Autowired
		UserRepository userRepository;
	
		@Autowired	
		PasswordEncoder passwordEncoder;
	
		@Override
		// @Bean
		public void run(String... args) throws Exception {
	
			if (userRepository.findByRole(Role.ADMIN) == null) {
				User admin = new User();
				admin.setPassword(passwordEncoder.encode("admin"));
				admin.setUsername("Proctor");
				admin.setFullName("Proctor");
				admin.setRole(Role.ADMIN);
				admin.setPhone("0947408989");

				userRepository.save(admin);
	
			}
		}

	public static void main(String[] args) {
		SpringApplication.run(StudentDormitoryAssistantApplication.class, args);
	}

}
