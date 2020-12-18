package everisdarmytasksms.firstproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import everisdarmytasksms.firstproject.model.Task;
import everisdarmytasksms.firstproject.repository.TaskRepository;

@Service
public class TaskService {
	
	
	@Autowired
	private TaskRepository taskRepo;
	
	//Get a single task by its ID
	public Task findTask(Long id) {
		
		Task t = new Task();
		
		if(taskRepo.findById(id).isPresent()) {
			t = taskRepo.findById(id).get();
		}
		
		return t;
	}
	
	//Get all tasks in database
	public List<Task> findAll() {
		
		var it = taskRepo.findAll();
		
		var tasks = new ArrayList<Task>();
		it.forEach(e -> tasks.add(e));
		
		return tasks;
	}
	
	//Add a new task to the database
	public void addTask(Task t) {
		
		if(t != null) {
			taskRepo.save(t);			
		} else {
			taskRepo.save(new Task());
		}
	}
	
	//Delete a task from the database
	public void deleteTask(Long id) {
		taskRepo.delete(this.findTask(id));
	}
	
	//Update a task from the database
	public Task updateTask(Long id, Task newTask) {
		Task t = this.findTask(id);
		
		t.setName(newTask.getName());
		t.setDescription(newTask.getDescription());
		t.setStatus(newTask.getStatus());
		
		taskRepo.save(t);
		
		return t;
	}
	
	//Get all tasks with status pending
	public List<Task> getAllPendingTasks() {
		List<Task> allTasks = this.findAll();
		String statusSearched = "Pending";
		
		return allTasks.stream().filter(e -> statusSearched.equals(e.getStatus())).collect(Collectors.toList());
	}
	
	//Get all tasks with status in progress
	public List<Task> getAllInProgressTasks() {
		List<Task> allTasks = this.findAll();
		String statusSearched = "In progress";
		
		return allTasks.stream().filter(e -> statusSearched.equals(e.getStatus())).collect(Collectors.toList());
	}
	
	//Get all tasks with status finished
	public List<Task> getAllFinishedTasks() {
		List<Task> allTasks = this.findAll();
		String statusSearched = "Finished";
		
		return allTasks.stream().filter(e -> statusSearched.equals(e.getStatus())).collect(Collectors.toList());
	}
}
