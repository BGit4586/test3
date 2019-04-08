package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Task;



public interface TaskRepository extends JpaRepository<Task, Long>{
	
	@Query( value = "select * from Task t where upper(t.description) like CONCAT('%',UPPER(:searchitem),'%') or upper(t.title) like CONCAT('%',UPPER(:searchitem),'%')" , 
			  nativeQuery = true)
	List<Task> findByDescriptionOrTitle(@Param("searchitem") String searchString);

}
