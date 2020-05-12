package com.main.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.project.domain.Project;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Long>{
	
	Project findByProjectIdentifier(String projectId);
	
	@Override
	Iterable<Project> findAll();
}
