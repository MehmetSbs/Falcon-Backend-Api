package com.internship.falcon.spec;

import com.internship.falcon.entity.User;
import com.internship.falcon.filter.UserFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

//public  class UserSpecification implements Specification<User> {
public  class UserSpecification  {

    /*private UserFilter userFilter;

    public UserSpecification(UserFilter userFilter){
        this.userFilter = userFilter;
    }*/

    public static Specification<User> generalFilter(UserFilter userFilter){
        return (Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) ->{

            Predicate predicate = criteriaBuilder.conjunction();

            if(userFilter.getUserName() != null && !userFilter.getUserName().equals("") ){
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(criteriaBuilder.lower(root.get("userName")), userFilter.getUserName().toLowerCase()));
            }

            if(userFilter.getUserSurname() != null && !userFilter.getUserSurname().equals("")){
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(criteriaBuilder.lower(root.get("userSurname")),userFilter.getUserSurname().toLowerCase()));
            }

            return predicate;
        };
    }

    /*@Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        Predicate predicate = criteriaBuilder.conjunction();

        if(userFilter.getUserName() != null && !userFilter.getUserName().equals("") ){
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(criteriaBuilder.lower(root.get("userName")), userFilter.getUserName().toLowerCase()));
        }

        if(userFilter.getUserSurname() != null && !userFilter.getUserSurname().equals("")){
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(criteriaBuilder.lower(root.get("userSurname")),userFilter.getUserSurname().toLowerCase()));
        }

        return predicate;
    }*/


}
