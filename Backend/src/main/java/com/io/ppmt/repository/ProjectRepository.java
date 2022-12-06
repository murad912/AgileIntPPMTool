package com.io.ppmt.repository;

import com.io.ppmt.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
     //Ctrl + O to see all method option
    Project findByProjectIdentifier(String projectId);

    @Override
    Iterable<Project> findAll();
}
