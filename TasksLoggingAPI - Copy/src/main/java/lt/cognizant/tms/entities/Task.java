package lt.cognizant.tms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String task_name;
	
	@Column
	private String time_spent_on_task;
	
	@Column
	private String task_group;
	
	@Column
	private String task_assignee;
	
	@Column
	private String subtasks;
	
	@Column
	private Boolean is_task_finished_flag;
	
	private TaskStatus status = TaskStatus.OPEN;
	
	

	public Task() {
		super();
	}

	public Task(Integer id, String task_name, String time_spent_on_task, String task_group, String task_assignee,
			String subtasks, Boolean is_task_finished_flag) {
		this.id = id;
		this.task_name = task_name;
		this.time_spent_on_task = time_spent_on_task;
		this.task_group = task_group;
		this.task_assignee = task_assignee;
		this.subtasks = subtasks;
		this.is_task_finished_flag = is_task_finished_flag;
	}

	public Task(String task_name, String time_spent_on_task, String task_group, String task_assignee,
			String subtasks, Boolean is_task_finished_flag) {
		this.task_name = task_name;
		this.time_spent_on_task = time_spent_on_task;
		this.task_group = task_group;
		this.task_assignee = task_assignee;
		this.subtasks = subtasks;
		this.is_task_finished_flag = is_task_finished_flag;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTime_spent_on_task() {
		return time_spent_on_task;
	}

	public void setTime_spent_on_task(String time_spent_on_task) {
		this.time_spent_on_task = time_spent_on_task;
	}

	public String getTask_group() {
		return task_group;
	}

	public void setTask_group(String task_group) {
		this.task_group = task_group;
	}

	public String getTask_assignee() {
		return task_assignee;
	}

	public void setTask_assignee(String task_assignee) {
		this.task_assignee = task_assignee;
	}

	public String getSubtasks() {
		return subtasks;
	}

	public void setSubtasks(String subtasks) {
		this.subtasks = subtasks;
	}

	public Boolean getIs_task_finished_flag() {
		return is_task_finished_flag;
	}

	public void setIs_task_finished_flag(Boolean is_task_finished_flag) {
		this.is_task_finished_flag = is_task_finished_flag;
	}
	
	public TaskStatus getStatus() {
		return status;
	}
	
	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", task_name=" + task_name + ", time_spent_on_task=" + time_spent_on_task
				+ ", task_group=" + task_group + ", task_assignee=" + task_assignee + ", subtasks=" + subtasks
				+ ", is_task_finished_flag=" + is_task_finished_flag + "status=" + status + "]";
	}
	
	
	
	
	
	
}
