package com.io.ppmt.services;


import com.io.ppmt.domain.Project;
import com.io.ppmt.exceptions.ProjectIdException;
import com.io.ppmt.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        String message = "";

        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            //update logic
            Project project1 = projectRepository.findByProjectIdentifier(project.getProjectIdentifier());

            if(project1 != null){
                project1.setProjectName(project.getProjectName());
                project1.setDescription(project.getDescription());
                project1.setStart_date(project.getStart_date());
                project1.setEnd_date(project.getEnd_date());
                project1.setUpdated_At(new Date());
            }
            else{
                project1 = new Project();
                project1.setProjectName(project.getProjectName());
                project1.setDescription(project.getDescription());
                project1.setProjectIdentifier(project.getProjectIdentifier());
                project1.setStart_date(project.getStart_date());
                project1.setEnd_date(project.getEnd_date());
                project1.setCreated_At(new Date());
            }
            return projectRepository.save(project1);

        }catch (Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }

    }

    public Project findProjectByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw new ProjectIdException("Project ID '"+projectId+"' does not exist");
        }
        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectid){
        Project project = projectRepository.findByProjectIdentifier(projectid.toUpperCase());

        if(project == null){
            throw new ProjectIdException("Cannot Project with ID ' "+projectid+"'. This project does not exist");
        }
        projectRepository.delete(project);
    }
}
