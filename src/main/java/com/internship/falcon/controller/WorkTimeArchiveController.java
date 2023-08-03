package com.internship.falcon.controller;

import com.internship.falcon.dto.WorkTimeArchiveDto;
import com.internship.falcon.entity.WorkTimeArchive;
import com.internship.falcon.filter.WorkTimeArchiveFilter;
import com.internship.falcon.service.WorkTimeArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workTimeArchive")
public class WorkTimeArchiveController {

    private final WorkTimeArchiveService workTimeArchiveService;

    @Autowired
    public  WorkTimeArchiveController(WorkTimeArchiveService workTimeArchiveService){
        this.workTimeArchiveService = workTimeArchiveService;
    }

    @GetMapping("get")
    public WorkTimeArchiveDto getWorkTimeArchiveById(@RequestParam Integer id){
        return  workTimeArchiveService.getWorkTimeArchiveById(id);
    }

    @PostMapping("get/filter")
    public List<WorkTimeArchiveDto> getWorkTimeArchiveByFilter(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "5") int size,
                                                               @RequestBody WorkTimeArchiveFilter workTimeArchiveFilter){
        return workTimeArchiveService.getWorkTimeArchiveByFilter(page, size, workTimeArchiveFilter);
    }

    @PostMapping("get/countByFilter")
    public long getWorkTimeArchiveCountByFilter(@RequestBody WorkTimeArchiveFilter workTimeArchiveFilter){
        return workTimeArchiveService.getWorkTimeArchiveCountByFilter(workTimeArchiveFilter);
    }

    @PostMapping("add")
    public String addWorkTimeArchive(@RequestBody WorkTimeArchive workTimeArchive){
        return workTimeArchiveService.addWorkTimeArchive(workTimeArchive);
    }

    @PutMapping("update")
    public String updateWorkTimeArchiveById(@RequestParam Integer id, @RequestBody WorkTimeArchive workTimeArchive){
        return  workTimeArchiveService.updateWorkTimeArchiveById(id,workTimeArchive);
    }

    @DeleteMapping("delete")
    public String deleteWorkTimeArchiveById(@RequestParam Integer id){
        return  workTimeArchiveService.deleteWorkTimeArchiveById(id);
    }
}
