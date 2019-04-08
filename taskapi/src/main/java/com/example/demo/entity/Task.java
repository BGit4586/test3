package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	private String description;
	private boolean isDone;
	protected Task() {
		super();
	}
	public Task(Long id, String title, String description, boolean isDone) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.isDone = isDone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", isDone=" + isDone + "]";
	}
	
	

}
