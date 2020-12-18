package everis.everisdarmytasksms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import everis.everisdarmytasksms.model.Task;
import everis.everisdarmytasksms.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/tasks", method=RequestMethod.GET)
	public List<Task> allTasks() {
		
		return taskService.findAll();
		
	}
	
	@RequestMapping(value="/tasks/get/{id}", method=RequestMethod.GET)
	public Task getTask(@PathVariable String id) {
		
		Long taskId = Long.parseLong(id);
		return taskService.findTask(taskId);
		
	}
	
	@PostMapping(value="/tasks/add", produces="application/json")
	public void addTask(Task t) {
		
		taskService.addTask(t);
	}
	
	@DeleteMapping(value="/tasks/delete/{id}")
	public void delete(@PathVariable String id) {
		
		Long taskId = Long.parseLong(id);
		taskService.deleteTask(taskId);
		
	}
	
	@PutMapping(value="/tasks/update/{id}")
	public void updateTask(@PathVariable String id, Task t) {
		
		taskService.updateTask(Long.parseLong(id), t);
	}
	

}

