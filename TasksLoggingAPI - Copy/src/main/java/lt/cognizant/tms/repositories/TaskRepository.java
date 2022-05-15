package lt.cognizant.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.cognizant.tms.entities.Task;


public interface TaskRepository extends JpaRepository<Task, Integer>{}