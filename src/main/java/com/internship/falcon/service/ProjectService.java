package com.internship.falcon.service;

import com.internship.falcon.dto.ProjectDto;
import com.internship.falcon.entity.Project;

public interface ProjectService {
    ProjectDto getProjectById(Integer id);

    String addProject(Project project);

    String updateProjectById(Integer id, Project project);

    String deleteProjectById(Integer id);
}
