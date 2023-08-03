package com.internship.falcon.filter;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WorkTimeArchiveFilter {

    private String projectName;
    private String userName;
    private String userSurname;
    private Date date;
    private Integer workAmount;


}
