package ir.co.isc.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@Configuration
//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"ir.co.isc.*"})
@EntityScan(basePackages = {"ir.co.isc.entity"})
@EnableJpaRepositories(basePackages = {"ir.co.isc.repository"})
public class AssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssignmentApplication.class, args);
    }

}
