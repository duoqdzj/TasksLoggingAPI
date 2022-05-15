package lt.cognizant.tms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.cognizant.tms.entities.Task;
import lt.cognizant.tms.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	TaskRepository taskRepository;
	
	public List<Task> getTasks(){
		return taskRepository.findAll();
	}
	
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}
	
	public Task getTask(Integer id) {
		return taskRepository.findById(id).orElse(null);
	}
	
	public Task updateTask(Task s) {
		Task old=this.getTask(s.getId());
		old.setTask_name(s.getTask_name());
		old.setTime_spent_on_task(s.getTime_spent_on_task());
		old.setTask_group(s.getTask_group());
		old.setIs_task_finished_flag(s.getIs_task_finished_flag());
		
		taskRepository.save(old);
		return old;
	}
	
	public void deleteTask(Integer id) {
		taskRepository.deleteById(id);
	}
	


}
