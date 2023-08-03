package com.internship.falcon.controller;

import com.internship.falcon.dto.ProjectDetailsDto;
import com.internship.falcon.entity.ProjectDetails;
import com.internship.falcon.service.ProjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("projectDetails")
public class ProjectDetailsController {

    private final ProjectDetailsService projectDetailsService;

    @Autowired
    public ProjectDetailsController(ProjectDetailsService projectDetailsService){
        this.projectDetailsService = projectDetailsService;
    }


    @GetMapping("get")
    public ProjectDetailsDto getProjectDetailsById(@RequestParam Integer id){
        return projectDetailsService.getProjectDetailsById(id);
    }

    @PostMapping("add")
    public String addProjectDetails(@RequestBody ProjectDetails projectDetails){
        return projectDetailsService.addProjectDetails(projectDetails);
    }

}
