package com.main.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.project.domain.Project;
import com.main.project.repository.ProjectRepo;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepo projectRepo;
	
	public Project saveOrUpdateProject(Project project) {
		
		return projectRepo.save(project);
	}
}
