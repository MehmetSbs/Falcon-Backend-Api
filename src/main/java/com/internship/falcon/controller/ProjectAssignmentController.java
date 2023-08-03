package com.internship.falcon.controller;

import com.internship.falcon.dto.ProjectAssignmentDto;
import com.internship.falcon.entity.ProjectAssignment;
import com.internship.falcon.service.ProjectAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("projectAssignment")
public class ProjectAssignmentController {

    private final ProjectAssignmentService projectAssignmentService;

    @Autowired
    public ProjectAssignmentController(ProjectAssignmentService projectAssignmentService){
        this.projectAssignmentService = projectAssignmentService;
    }

    @GetMapping("get")
    public ProjectAssignmentDto getProjectAssignmentById(@RequestParam Integer id){
        return projectAssignmentService.getProjectAssignmentById(id);
    }

    @PostMapping("add")
    public String addProjectAssignment(@RequestBody ProjectAssignment projectAssignment){
        return  projectAssignmentService.addProjectAssignment(projectAssignment);
    }

    @PutMapping("update")
    public String updateProjectAssignmentById(@RequestParam Integer id, @RequestBody ProjectAssignment projectAssignment){
        return projectAssignmentService.updateProjectAssignmentById(id,projectAssignment);
    }

    @DeleteMapping("delete")
    public String deleteProjectAssignmentById(@RequestParam Integer id){
        return projectAssignmentService.deleteProjectAssignmentById(id);
    }

}
