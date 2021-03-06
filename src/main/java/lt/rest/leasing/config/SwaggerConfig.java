package lt.rest.leasing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(metadata())
				.select()
				.apis(RequestHandlerSelectors.basePackage("lt.rest.leasing"))
				.build();
	}

	public ApiInfo metadata() {
		return new ApiInfoBuilder().title("REST API documentation").description("Rest api for leasing. ")
				.version("1.0").build();
	}

}