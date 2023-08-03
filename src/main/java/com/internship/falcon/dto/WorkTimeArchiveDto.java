package com.internship.falcon.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class WorkTimeArchiveDto {

    private ProjectAssignmentDto projectAssignmentDto;
    private Date date;
    private Integer workAmount;

    public WorkTimeArchiveDto(Builder builder){
        this.projectAssignmentDto = builder.projectAssignmentDto;
        this.date = builder.date;
        this.workAmount = builder.workAmount;
    }

    public static class Builder{

        private Integer workAmount;
        private Date date;
        private ProjectAssignmentDto projectAssignmentDto;

        public Builder workAmount(final Integer workAmount){
            this.workAmount = workAmount;
            return this;
        }
        public Builder date(final Date date){
            this.date = date;
            return this;
        }
        public Builder projectAssignmentDto(final ProjectAssignmentDto projectAssignmentDto){
            this.projectAssignmentDto = projectAssignmentDto;
            return this;
        }


        public WorkTimeArchiveDto build(){
            return new WorkTimeArchiveDto(this);
        }


    }
}
