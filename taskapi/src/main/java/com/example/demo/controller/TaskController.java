package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	//Get All Tasks
	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
		System.out.println("in GetAll");
		return taskService.findAll();
	}
	
	@GetMapping("/tasks/{id}")
	public Task getTodo( @PathVariable long id) {

		return taskService.findById(id);
	}
	
	@GetMapping("/tasks/search/{searchstring}")
	public List<Task> getTodos( @PathVariable String  searchstring) {

		return taskService.findByDescriptionOrTitle(searchstring);
	}
	
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Void> deleteTodo( @PathVariable long id) {

		taskService.deleteById(id);
		return ResponseEntity.noContent().build();

	}
	
	//Edit/Update a Todo
	
		@PutMapping("/tasks/{id}")
		public ResponseEntity<Task> updateTodo(
	 			
	 			@PathVariable long id, @RequestBody Task todo){
			
			Task todoUpdated = taskService.save(todo);
			
			return new ResponseEntity<Task>(todo, HttpStatus.OK);
		}
		
		@PostMapping("/tasks")
		public ResponseEntity<Void> updateTodo(
	 			 @RequestBody Task todo){
			
			
			Task createdTodo = taskService.save(todo);
			
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
			
			return ResponseEntity.created(uri).build();
		}
	

}
