package com.internship.falcon.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectDetailsDto {

    private ProjectDto projectDto;
    private String description;

    public ProjectDetailsDto(Builder builder){
        this.projectDto = builder.projectDto;
        this.description = builder.description;
    }

    @NoArgsConstructor
    public static class Builder{
        private ProjectDto projectDto;
        private String description;

        public Builder project(final ProjectDto projectDto){
            this.projectDto = projectDto;
            return this;
        }

        public Builder description(final String description){
            this.description = description;
            return this;
        }

        public ProjectDetailsDto build(){
            return new ProjectDetailsDto(this);
        }

    }

}
