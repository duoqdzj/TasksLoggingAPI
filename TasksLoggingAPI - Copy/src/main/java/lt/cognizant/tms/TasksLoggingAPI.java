package lt.cognizant.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lt.cognizant.tms.validation.TaskUpdateValidator;




@SpringBootApplication
public class TasksLoggingAPI {
	
	@Bean
	public TaskUpdateValidator taskdUpdateValidator() {
		return new TaskUpdateValidator();
	}

	public static void main(String[] args) {
		SpringApplication.run(TasksLoggingAPI.class, args);
	}

}
