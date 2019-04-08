package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Task;

public interface TaskService {
	
	public List<Task> findAll();
	
	public Task save(Task todo);

	public void deleteById(Long theId);
	
	public List<Task> findByDescriptionOrTitle(String searchString);

	public Task findById(long id);

}
