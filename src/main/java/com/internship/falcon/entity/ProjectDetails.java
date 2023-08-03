package com.internship.falcon.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "project_details")
@Data
public class ProjectDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "description")
    private String description;
}
