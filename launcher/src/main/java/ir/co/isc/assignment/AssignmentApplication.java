package ir.co.isc.assignment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import ir.co.isc.ControllerExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableAutoConfiguration
@Import(ControllerExceptionHandler.class)
@ComponentScan(basePackages = {"ir.co.isc.*"})
@EntityScan(basePackages = {"ir.co.isc.entity"})
@EnableJpaRepositories(basePackages = {"ir.co.isc.repository"})
@EnableScheduling
@OpenAPIDefinition(info = @Info(title = "account api", version = "1.0", description = "api document for isc assignment"))
public class AssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
    }

}
