package com.radi.endtoend.tweeter;

import com.radi.endtoend.tweeter.model.Role;
import com.radi.endtoend.tweeter.model.User;
import com.radi.endtoend.tweeter.repository.RoleRepository;
import com.radi.endtoend.tweeter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TweeterApplication implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(TweeterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role userRole = new Role("USER");
		Role adminRole = new Role("ADMIN");
		Set userroles = new HashSet();
		userroles.add(userRole);
		Set adminroles = new HashSet();
		adminroles.add(adminRole);
		User anup = new User("anup",bCryptPasswordEncoder.encode("anup"), userroles);
		User venkat = new User("venkat",bCryptPasswordEncoder.encode("venkat"), userroles);
		User gulam = new User("gulam",bCryptPasswordEncoder.encode("gulam"), adminroles);

		roleRepository.save(userRole);
		roleRepository.save(adminRole);
		roleRepository.flush();
		userRepository.save(anup);
		userRepository.save(venkat);
		userRepository.save(gulam);
	}
}
