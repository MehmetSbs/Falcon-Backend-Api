package com.internship.falcon.controller;


import com.internship.falcon.dto.ProjectDto;
import com.internship.falcon.entity.Project;
import com.internship.falcon.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("get")
    public ProjectDto getProjectById(@RequestParam Integer id){
        return projectService.getProjectById(id);
    }

    @PostMapping("add")
    public  String addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @PutMapping("update")
    public String updateProjectById(@RequestParam Integer id, @RequestBody Project project){
        return  projectService.updateProjectById(id, project);
    }

    @DeleteMapping("delete")
    public String deleteProjectById(@RequestParam Integer id){
        return projectService.deleteProjectById(id);
    }
}
