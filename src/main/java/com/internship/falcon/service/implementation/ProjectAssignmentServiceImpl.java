package com.internship.falcon.service.implementation;

import com.internship.falcon.dto.ProjectAssignmentDto;
import com.internship.falcon.dto.mapper.Mapper;
import com.internship.falcon.entity.ProjectAssignment;
import com.internship.falcon.repository.ProjectAssignmentRepository;
import com.internship.falcon.service.ProjectAssignmentService;
import com.internship.falcon.enums.MessagesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectAssignmentServiceImpl implements ProjectAssignmentService {

    private final ProjectAssignmentRepository projectAssignmentRepository;

    @Autowired
    public ProjectAssignmentServiceImpl(ProjectAssignmentRepository projectAssignmentRepository){
        this.projectAssignmentRepository = projectAssignmentRepository;
    }


    @Override
    public ProjectAssignmentDto getProjectAssignmentById(Integer id) {
        return Mapper.projectAssignmentDtoMapper(projectAssignmentRepository.findById(id).get());
    }

    @Override
    public String addProjectAssignment(ProjectAssignment projectAssignment) {
        projectAssignmentRepository.save(projectAssignment);
        return MessagesEnum.successfullyAdded.getValue();
    }

    @Override
    public String updateProjectAssignmentById(Integer id, ProjectAssignment projectAssignment) {

        ProjectAssignment proA = projectAssignmentRepository.findById(id).get();

        if(projectAssignment.getUser() != null){
            proA.setUser(projectAssignment.getUser());
        }
        if(projectAssignment.getProject() != null){
            proA.setProject(projectAssignment.getProject());
        }

        projectAssignmentRepository.save(proA);
        return MessagesEnum.successfullyUpdated.getValue();
    }

    @Override
    public String deleteProjectAssignmentById(Integer id) {
        projectAssignmentRepository.deleteById(id);
        return MessagesEnum.successfullyDeleted.getValue();
    }
}
