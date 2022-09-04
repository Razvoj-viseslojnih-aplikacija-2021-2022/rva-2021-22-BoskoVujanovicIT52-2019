package rppstart;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "rpp-start.*")
public class RppStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(RppStartApplication.class, args);
	}
}
