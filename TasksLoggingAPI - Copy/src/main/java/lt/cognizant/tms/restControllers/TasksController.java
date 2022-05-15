package lt.cognizant.tms.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.cognizant.tms.entities.Task;
import lt.cognizant.tms.services.TaskService;
import lt.cognizant.tms.validation.TaskUpdateValidator;


@RestController
@RequestMapping("/api")
public class TasksController {
	@Autowired
	TaskService taskService;
	TaskUpdateValidator taskValidator;
	
	@CrossOrigin
	@GetMapping("/getAllTask")
	public List<Task> index(){
		return taskService.getTasks();
	}
	
	@CrossOrigin
	@PostMapping("/createTask")
	public Task add(@RequestBody Task s)
	{
		return taskService.saveTask(s);
	}
	
	@CrossOrigin
	@PatchMapping("/editTask/{id}")
	public Task update(@PathVariable Integer id, @RequestBody Task s, BindingResult result) {
		
		taskValidator.validate(s, result);
		
		return taskService.updateTask(s);
	}
	
	@CrossOrigin
	@DeleteMapping("/deleteTask/{id}")
	public Boolean delete(@PathVariable Integer id) {
		taskService.deleteTask(id);
		return true;
	}
	
	
}
