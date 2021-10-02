package com.progmatic.java.backend.University;

import com.progmatic.java.backend.University.config.ConfigReader;
import com.progmatic.java.backend.University.model.Major;
import com.progmatic.java.backend.University.module.MajorHandler;
import com.progmatic.java.backend.University.module.MajorLoader;
import com.progmatic.java.backend.University.module.WeakList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class UniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);

		ConfigReader configReader = new ConfigReader();
		MajorLoader majorLoader = new MajorLoader(configReader);
		MajorHandler majorHandler = new MajorHandler(majorLoader, configReader);

		WeakList weakList = new WeakList(majorHandler);
		boolean weakies = weakList.majorsWithWeak();
		//List<Major> weakies = weakList.majorsWithWeak();

		System.out.println(weakies);
	}

}
