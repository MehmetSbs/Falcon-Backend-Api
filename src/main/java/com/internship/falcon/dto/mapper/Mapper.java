package com.internship.falcon.dto.mapper;

import com.internship.falcon.dto.*;
import com.internship.falcon.entity.*;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static ProjectAssignmentDto projectAssignmentDtoMapper(ProjectAssignment projectAssignment){


        return new ProjectAssignmentDto.Builder()
                .userDto(userDtoMapper(projectAssignment.getUser()))
                .projectDto(projectDtoMapperWithoutAssignmentList(projectAssignment.getProject()))
                .build();

    }
    public static ProjectAssignmentDto projectAssignmentDtoMapperWithoutProject(ProjectAssignment projectAssignment){


        return new ProjectAssignmentDto.Builder()
                .userDto(userDtoMapper(projectAssignment.getUser()))
                .build();

    }


    public static List<ProjectAssignmentDto> projectAssignmentDtoListMapper(List<ProjectAssignment> projectAssignmentList){
        List<ProjectAssignmentDto> pAssignmentDtoList = new ArrayList<>();

        projectAssignmentList.forEach((n) -> pAssignmentDtoList.add(projectAssignmentDtoMapper(n)));

        return pAssignmentDtoList;
    }
    public static List<ProjectAssignmentDto> projectAssignmentDtoListMapperWithoutProject(List<ProjectAssignment> projectAssignmentList){
        List<ProjectAssignmentDto> pAssignmentDtoList = new ArrayList<>();

        projectAssignmentList.forEach((n) -> pAssignmentDtoList.add(projectAssignmentDtoMapperWithoutProject(n)));

        return pAssignmentDtoList;
    }


    public static UserDto userDtoMapper(User user){


        return new UserDto.Builder()
                .userName(user.getUserName())
                .userSurname(user.getUserSurname())
                .build();

    }

    public static List<UserDto> userDtoListMapper(List<User> userList){
        List<UserDto> userDtoList = new ArrayList<>();

        userList.forEach((n) -> userDtoList.add(userDtoMapper(n)));

        return  userDtoList;

    }

    public static ProjectDto projectDtoMapper(Project project){


        return new ProjectDto.Builder()
                .projectName(project.getProjectName())
                .projectManagerDto(userDtoMapper(project.getProjectManager()))
                .assignmentList(projectAssignmentDtoListMapperWithoutProject(project.getProjectAssignmentList()))
                .projectDetailsDto(projectDetailsDtoMapperWithoutProject(project.getProjectDetails()))
                .build();

    }

    public static ProjectDto projectDtoMapperWithoutAssignmentList(Project project){


        return new ProjectDto.Builder()
                .projectName(project.getProjectName())
                .projectManagerDto(userDtoMapper(project.getProjectManager()))
                .build();

    }

    public static WorkTimeArchiveDto workTimeArchiveDtoMapper(WorkTimeArchive workTimeArchive){

        return  new WorkTimeArchiveDto.Builder()
                .projectAssignmentDto(projectAssignmentDtoMapper(workTimeArchive.getProjectAssignment()))
                .date(workTimeArchive.getDate())
                .workAmount(workTimeArchive.getWorkAmount())
                .build();
    }

    public static List<WorkTimeArchiveDto> workTimeArchiveDtoListMapper(List<WorkTimeArchive> workTimeArchiveList){
        List<WorkTimeArchiveDto> workTimeArchiveDtoList = new ArrayList<>();

        workTimeArchiveList.forEach((n) -> workTimeArchiveDtoList.add(workTimeArchiveDtoMapper(n)));
        return  workTimeArchiveDtoList;

    }

    public static ProjectDetailsDto projectDetailsDtoMapper(ProjectDetails projectDetails){

        return new ProjectDetailsDto.Builder()
                .project(projectDtoMapper(projectDetails.getProject()))
                .description(projectDetails.getDescription())
                .build();
    }

    public static ProjectDetailsDto projectDetailsDtoMapperWithoutProject(ProjectDetails projectDetails){

        return new ProjectDetailsDto.Builder()
                .description(projectDetails.getDescription())
                .build();
    }



}
