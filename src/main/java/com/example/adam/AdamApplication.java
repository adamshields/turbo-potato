package com.example.adam;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EntityScan(basePackages = {"com.example.adam.entity"})
@EnableScheduling
public class AdamApplication {

//	@Bean
//	public ModelMapper modelMapper(){
//		return new ModelMapper();
//	}

	public static void main(String[] args) {
		SpringApplication.run(AdamApplication.class, args);
	}

}
