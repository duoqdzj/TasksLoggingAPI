package lt.cognizant.tms.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import lt.cognizant.tms.entities.Task;
import lt.cognizant.tms.entities.TaskStatus;

public class TaskUpdateValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}


	@Override
	public void validate(Object target, Errors errors) {
		Task task = (Task) target;
		
		
		TaskStatus status = task.getStatus();
		if((task.getIs_task_finished_flag() != null && status != TaskStatus.COMPLETED) || 
		   (status != null && status == TaskStatus.RESERVED) ) {
			errors.rejectValue("status", "field.invalid", "Invalid status");			
		}
	}


}
