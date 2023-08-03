package com.internship.falcon.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectAssignmentDto {

    public ProjectAssignmentDto(Builder builder){
        this.projectDto = builder.projectDto;
        this.userDto = builder.userDto;
    }

    private ProjectDto projectDto;
    private UserDto userDto;

    @NoArgsConstructor
    public static class Builder{

        private ProjectDto projectDto;
        private UserDto userDto;

        public Builder projectDto(final ProjectDto projectDto){
            this.projectDto = projectDto;
            return this;
        }

        public Builder userDto(final UserDto userDto){
            this.userDto = userDto;
            return this;
        }


        public ProjectAssignmentDto build(){
            return new ProjectAssignmentDto(this);
        }

    }

}
