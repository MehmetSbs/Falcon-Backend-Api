package com.internship.falcon.repository;

import com.internship.falcon.entity.WorkTimeArchive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WorkTimeArchiveRepository extends JpaRepository<WorkTimeArchive,Integer>, JpaSpecificationExecutor<WorkTimeArchive> {
}
