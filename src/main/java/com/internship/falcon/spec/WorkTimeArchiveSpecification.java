package com.internship.falcon.spec;

import com.internship.falcon.entity.WorkTimeArchive;
import com.internship.falcon.filter.WorkTimeArchiveFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class WorkTimeArchiveSpecification{


    public static Specification<WorkTimeArchive> generalFilter(WorkTimeArchiveFilter workTimeArchiveFilter){
        return (Root<WorkTimeArchive> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            Predicate p = criteriaBuilder.conjunction();

            if(workTimeArchiveFilter.getProjectName() != null && !workTimeArchiveFilter.getProjectName().equals("")){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("projectAssignment").get("project").get("projectName")),"%"+ workTimeArchiveFilter.getProjectName().toLowerCase()+"%"));
            }

            if(workTimeArchiveFilter.getUserName() != null && !workTimeArchiveFilter.getUserName().equals("")){
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("projectAssignment").get("user").get("userName")),"%"+ workTimeArchiveFilter.getUserName().toLowerCase()+"%"));
            }

            if(workTimeArchiveFilter.getUserSurname() != null && !workTimeArchiveFilter.getUserSurname().equals("")){
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("projectAssignment").get("user").get("userSurname")),"%"+ workTimeArchiveFilter.getUserSurname().toLowerCase()+"%"));
            }

            if(workTimeArchiveFilter.getWorkAmount() != null) {
                predicates.add(criteriaBuilder.equal(root.get("workAmount"), workTimeArchiveFilter.getWorkAmount()));
            }

            if(workTimeArchiveFilter.getDate() != null && !workTimeArchiveFilter.getDate().toString().equals("")){
                predicates.add(criteriaBuilder.equal(root.get("date"), workTimeArchiveFilter.getDate()));
            }

            p = criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            return p;
        };
    }
}
