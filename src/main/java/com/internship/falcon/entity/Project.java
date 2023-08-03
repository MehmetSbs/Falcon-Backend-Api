package com.internship.falcon.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "project")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Column(name = "project_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;

    @ManyToOne
    @JoinColumn(name = "project_manager_id")
    private User projectManager;

    @Column(name = "project_name")
    private String projectName;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private List<ProjectAssignment> projectAssignmentList;


    @OneToOne(fetch = FetchType.EAGER, mappedBy = "project")
    private ProjectDetails projectDetails;
}
