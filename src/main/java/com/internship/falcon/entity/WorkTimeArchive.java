package com.internship.falcon.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "work_time_archive")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkTimeArchive {

    @Column(name = "archive_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer archiveId;

    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id")
    private ProjectAssignment projectAssignment;

    @Column(name = "work_amount")
    private  Integer workAmount;

}
