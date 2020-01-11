package com.crissantos.helpdesk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.crissantos.helpdesk.api.entity.User;
import com.crissantos.helpdesk.api.enums.ProfileEnum;
import com.crissantos.helpdesk.api.repository.UserRepository;

@SpringBootApplication
public class HelpdeskApplication {
	
		public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}
		
	@Bean
	CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args ->{
			initUsers(userRepository, passwordEncoder);
		};		
	}
		
	private void initUsers(UserRepository UserRepository, PasswordEncoder passwordEncoder) 
	{
		User admin = new User();
		admin.setEmail("criscgweb@gmail.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setProfile(ProfileEnum.ROLE_ADMI);
			
		User find = UserRepository.findByEmail("criscgweb@gmail.com");
		if (find == null) {
			UserRepository.save(admin);
			}
		}
}