package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.repositories.AuthoritiesRepository;
import com.example.persistence.*;
import com.example.repositories.*;

@Component
public class DataLoader implements ApplicationRunner {
	UserRepository userRepository;
	AuthoritiesRepository authoritiesRepository;
	PlatRepository platRepository;
	
	@Autowired
	public DataLoader(UserRepository userRepository, 
			AuthoritiesRepository authoritiesRepository,
			PlatRepository platRepository) {
		this.userRepository = userRepository;
		this.authoritiesRepository = authoritiesRepository;
		this.platRepository = platRepository;
	}



	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("user","user",true);
		//userRepository.save(user);
		
		User admin = new User("admin","admin",false);
		User admin2 = new User("admin2","admin2",true);
		//userRepository.save(admin);
		
		authoritiesRepository.save(new Authorities(user,"ROLE_USER"));
		authoritiesRepository.save(new Authorities(admin,"ROLE_ADMIN"));
		authoritiesRepository.save(new Authorities(admin2,"ROLE_ADMIN"));
		
		platRepository.save(new Plat("Pizza",999,10));
		platRepository.save(new Plat("Sandwich",500,20));
		platRepository.save(new Plat("Crepes",200,50));
		
	}

}
