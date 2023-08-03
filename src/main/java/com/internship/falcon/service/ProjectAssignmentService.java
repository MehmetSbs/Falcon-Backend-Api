package com.internship.falcon.service;

import com.internship.falcon.dto.ProjectAssignmentDto;
import com.internship.falcon.entity.ProjectAssignment;

public interface ProjectAssignmentService {
    ProjectAssignmentDto getProjectAssignmentById(Integer id);

    String addProjectAssignment(ProjectAssignment projectAssignment);

    String updateProjectAssignmentById(Integer id, ProjectAssignment projectAssignment);

    String deleteProjectAssignmentById(Integer id);
}
