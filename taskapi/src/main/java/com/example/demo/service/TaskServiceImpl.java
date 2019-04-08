package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public Task save(Task todo) {
		return	taskRepository.save(todo);
	}

	@Override
	public void deleteById(Long theId) {
		taskRepository.deleteById(theId);
	}

	@Override
	public List<Task> findByDescriptionOrTitle(String searchString) {
		return taskRepository.findByDescriptionOrTitle(searchString);
	}

	@Override
	public Task findById(long id) {
Optional<Task> result = taskRepository.findById(id);
		
		Task task = null;
		
		if (result.isPresent()) {
			task= result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find todo id - " + id);
		}
		
		return task;
	}
	}


