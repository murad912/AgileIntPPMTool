package com.io.ppmt.services;


import com.io.ppmt.domain.Project;
import com.io.ppmt.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private  ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        //Logic to save or update


        return projectRepository.save(project);
    }
}
