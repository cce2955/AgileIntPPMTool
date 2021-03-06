package com.main.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.project.domain.Project;
import com.main.project.exceptions.ProjectIdException;
import com.main.project.repository.ProjectRepo;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepo projectRepo;
	
	public Project saveOrUpdateProject(Project project) {
		try {
			project.setProjectIdentifier(
					project.getProjectIdentifier().toUpperCase());
			return projectRepo.save(project);
		}catch( Exception e) {
			throw new ProjectIdException("Project ID '" 
					+ project.getProjectIdentifier().toUpperCase() 
						+ "' already exists");
		}
	}
	
	
	public Project findProjectByIdentifier(String projectId) {
		Project project = projectRepo.findByProjectIdentifier(projectId.toUpperCase());
		
		if (project == null) {
			throw new ProjectIdException("Project ID '" 
					+ projectId 
						+ "' doesn't exist");
		}
		return project;
	}
	
	public Iterable<Project> findAllProjects(){
		return projectRepo.findAll();
	}
	
	public void deleteProjectByIdentifier (String projectId) {
		Project project = projectRepo.findByProjectIdentifier(projectId.toUpperCase());
		
		if (project == null) {
			throw new ProjectIdException("cannot delete project with ID: " + projectId + ". ID doesn't not exist");
		}
		
		projectRepo.delete(project);
	}
	
	
	
}
