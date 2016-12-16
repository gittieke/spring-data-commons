package be.jslm.exercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApp {
	
  private static final Logger log = LoggerFactory.getLogger(MyApp.class);

  public static void main(String[] args) {
    SpringApplication.run(MyApp.class, args);
  }
  
  @Bean
	public CommandLineRunner demo(EmployeeRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Employee("Jack", "Bauer", "24"));
			
			// count Employees			
			log.info("How many employees are in this EmployeeRepository?");
			log.info(String.format("Employees found with count(): '%d'", repository.count()));
			log.info("-------------------------------");						

			// fetch all employees
			log.info("Employees found with findAll():");
			log.info("-------------------------------");
			for (Employee employee: repository.findAll()) {
				log.info(employee.toString());
			}
			log.info("");			

			// fetch an individual customer by ID
			Employee employee = repository.findOne(1L);
			log.info("Employee found with findOne(1L):");
			log.info("--------------------------------");
			log.info(employee.toString());
			log.info("");

			// fetch employee by last name
			log.info("Employee found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Employee bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
			
		};	
	}
  
}