package com.hivetech.EmployeeRecords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@EnableAsync
//@Import(SwaggerConfiguration.class)
public class EmployeeRecordsApplication {

    @RequestMapping("/")
    public String helloWorld(){
        return "Hello World!";
    }
	public static void main(String[] args) {
		SpringApplication.run(EmployeeRecordsApplication.class, args);
	}

}
