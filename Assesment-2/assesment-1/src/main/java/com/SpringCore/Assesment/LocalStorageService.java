package com.SpringCore.Assesment;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;




@Component("localStorage")
@Lazy
@Scope("prototype")
public class LocalStorageService implements StorageService{


	public LocalStorageService() {
		System.out.println("LocalStorageService Bean Created"+ hashCode());
	}
	@PostConstruct
	public void init() {
		System.out.println("Initialized");
	}

	@Override
	public void storeFile(String fileName) {
		System.out.println("File stored in Local Storage: "+fileName);
	}
	
	@PreDestroy
	public void destroyed() {
		System.out.println("LocalStorageService Bean Destroyed");
	}

}
