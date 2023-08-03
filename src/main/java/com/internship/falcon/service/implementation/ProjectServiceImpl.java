package com.internship.falcon.service.implementation;

import com.internship.falcon.dto.ProjectDto;
import com.internship.falcon.dto.mapper.Mapper;
import com.internship.falcon.entity.Project;
import com.internship.falcon.repository.ProjectRepository;
import com.internship.falcon.service.ProjectService;
import com.internship.falcon.enums.MessagesEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDto getProjectById(Integer id) {
        return Mapper.projectDtoMapper(projectRepository.findById(id).get());
    }

    @Override
    public String addProject(Project project) {

        projectRepository.save(project);
        return MessagesEnum.successfullyAdded.getValue();
    }

    @Override
    public String updateProjectById(Integer id, Project project) {
        Project pro = projectRepository.findById(id).get();

        pro.setProjectManager(project.getProjectManager());
        pro.setProjectName(project.getProjectName());

        projectRepository.save(pro);

        return MessagesEnum.successfullyUpdated.getValue();
    }

    @Override
    public String deleteProjectById(Integer id) {
        projectRepository.deleteById(id);
        return MessagesEnum.successfullyDeleted.getValue();
    }
}
