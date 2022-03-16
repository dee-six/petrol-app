package ch.diyamane.app.petrol.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PetrolBusinessResourceApplication {

  public static void main(String[] args) {
    SpringApplication.run(PetrolBusinessResourceApplication.class, args);
  }

}
