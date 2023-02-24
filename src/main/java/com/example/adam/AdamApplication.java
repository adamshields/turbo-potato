package com.example.adam;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.modelmapper.ModelMapper;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.adam.entity"})
public class AdamApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(AdamApplication.class, args);
	}
//	@Bean
//	public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
//		return new OpenAPI().info(new Info().title("Foobar API")
//				.version(appVersion)
//				.description("This is a sample Foobar server created using springdocs - a library for OpenAPI 3 with spring boot.")
//				.termsOfService("http://swagger.io/terms/")
//				.license(new License().name("Apache 2.0")
//						.url("http://springdoc.org")));
//	}
//@Bean
//public GroupedOpenApi publicApi() {
//	return GroupedOpenApi.builder()
//			.group("springshop-public")
//			.pathsToMatch("/public/**")
//			.build();
//}
//	@Bean
//	public GroupedOpenApi adminApi() {
//		return GroupedOpenApi.builder()
//				.group("springshop-admin")
//				.pathsToMatch("/admin/**")
//				.addMethodFilter(method -> method.isAnnotationPresent(Admin.class))
//				.build();
//	}
}
