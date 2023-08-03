package com.internship.falcon.service;

import com.internship.falcon.dto.ProjectDetailsDto;
import com.internship.falcon.entity.ProjectDetails;

public interface ProjectDetailsService {

    ProjectDetailsDto getProjectDetailsById(Integer id);

    String addProjectDetails(ProjectDetails projectDetails);
}
