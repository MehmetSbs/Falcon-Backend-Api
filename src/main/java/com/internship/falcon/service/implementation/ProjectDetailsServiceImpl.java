package com.internship.falcon.service.implementation;

import com.internship.falcon.dto.ProjectDetailsDto;
import com.internship.falcon.dto.mapper.Mapper;
import com.internship.falcon.entity.ProjectDetails;
import com.internship.falcon.enums.MessagesEnum;
import com.internship.falcon.repository.ProjectDetailsRepository;
import com.internship.falcon.service.ProjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectDetailsServiceImpl implements ProjectDetailsService {

    private final ProjectDetailsRepository projectDetailsRepository;

    @Autowired
    public ProjectDetailsServiceImpl(ProjectDetailsRepository projectDetailsRepository){
        this.projectDetailsRepository = projectDetailsRepository;
    }


    @Override
    public ProjectDetailsDto getProjectDetailsById(Integer id) {
        return Mapper.projectDetailsDtoMapper(projectDetailsRepository.findById(id).get());
    }

    @Override
    public String addProjectDetails(ProjectDetails projectDetails) {
        projectDetailsRepository.save(projectDetails);
        return MessagesEnum.successfullyAdded.getValue();
    }
}
