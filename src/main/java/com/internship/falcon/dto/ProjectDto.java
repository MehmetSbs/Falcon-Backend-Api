package com.internship.falcon.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectDto {

    public ProjectDto(Builder builder){
        this.projectName = builder.projectName;
        this.projectManagerDto = builder.projectManagerDto;
        this.assignmentList = builder.assignmentList;
        this.projectDetailsDto = builder.projectDetailsDto;
    }

    private String projectName;
    private UserDto projectManagerDto;
    private List<ProjectAssignmentDto> assignmentList;
    private ProjectDetailsDto projectDetailsDto;

    @NoArgsConstructor
    public static class Builder{

        private String projectName;
        private UserDto projectManagerDto;
        private List<ProjectAssignmentDto> assignmentList;
        private ProjectDetailsDto projectDetailsDto;

        public Builder projectName(final String projectName){
            this.projectName = projectName;
            return this;
        }
        public Builder projectManagerDto(final UserDto projectManagerDto){
            this.projectManagerDto = projectManagerDto;
            return this;
        }
        public Builder assignmentList(final List<ProjectAssignmentDto> assignmentList){
            this.assignmentList = assignmentList;
            return this;
        }

        public Builder projectDetailsDto(final ProjectDetailsDto projectDetailsDto){
            this.projectDetailsDto = projectDetailsDto;
            return this;
        }



        public  ProjectDto build(){
            return new ProjectDto(this);
        }
    }

}
