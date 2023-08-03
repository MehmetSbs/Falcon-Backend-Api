package com.internship.falcon.service.implementation;

import com.internship.falcon.dto.UserDto;
import com.internship.falcon.dto.mapper.Mapper;
import com.internship.falcon.entity.User;
import com.internship.falcon.filter.UserFilter;
import com.internship.falcon.repository.UserRepository;
import com.internship.falcon.service.UserService;
import com.internship.falcon.enums.MessagesEnum;
import com.internship.falcon.spec.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UserDto getUserById(Integer id) {
        return Mapper.userDtoMapper(userRepository.findById(id).get());
    }

    @Override
    public String addUser(User user) {
        userRepository.save(user);
        return MessagesEnum.successfullyAdded.getValue();
    }

    @Override
    public String updateUserById(Integer id, User user) {
        User emp = userRepository.findById(id).get();

        if(user.getUserName() != null) {
            emp.setUserName(user.getUserName());        }
        if(user.getUserSurname() != null){
            emp.setUserSurname(user.getUserSurname());
        }

        userRepository.save(emp);
        return MessagesEnum.successfullyUpdated.getValue();
    }

    @Override
    public String deleteUserById(Integer id) {
        userRepository.deleteById(id);
        return MessagesEnum.successfullyDeleted.getValue();
    }

    @Override
    public List<UserDto> getAllUsers() {
        return Mapper.userDtoListMapper(userRepository.findAll());
    }

    @Override
    public List<UserDto> getAllUsersPageableByUserSurname(int page, int size, String userSurname) {

        Pageable paging = PageRequest.of(page,size);

        return Mapper.userDtoListMapper(userRepository.findAllByUserSurname(userSurname,paging).getContent());
    }

    @Override
    public List<UserDto> getAllUsersPageable(int page, int size, String sortByUserSurname) {

        Pageable paging;

        if(sortByUserSurname.equals("true")){
            paging = PageRequest.of(page,size,Sort.by("userSurname"));
        }
        else {
            paging = PageRequest.of(page,size);
        }


        return Mapper.userDtoListMapper(userRepository.findAll(paging).getContent());
    }

    @Override
    public long getNumberOfUsers() {
        return userRepository.count();
    }

    @Override
    public List<UserDto> getUsersByFilter(int page, int size, UserFilter userFilter) {
        //UserSpecification userSpecification = new UserSpecification(userFilter);
        //return Mapper.userDtoListMapper(userRepository.findAll(userSpecification, pageable).getContent());


        Pageable pageable = PageRequest.of(page,size);
        return Mapper.userDtoListMapper(userRepository.findAll(UserSpecification.generalFilter(userFilter), pageable).getContent());
    }

    @Override
    public long getNumberOfUsersBySurname(String userSurname) {

        return userRepository.countByUserSurname(userSurname);
    }

}
