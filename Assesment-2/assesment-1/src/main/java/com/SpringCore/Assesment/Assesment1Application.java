package com.SpringCore.Assesment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Assesment1Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(Assesment1Application.class, args);
		StorageService service= context.getBean(StorageService.class);

		service.storeFile("file.txt");
		
		StorageService local1= context.getBean("localStorage",StorageService.class);
		local1.storeFile("file2.txt");
		StorageService local2= context.getBean("localStorage",StorageService.class);
		
		
		
	}

}
