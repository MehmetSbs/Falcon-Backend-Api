package com.internship.falcon.service;

import com.internship.falcon.dto.UserDto;
import com.internship.falcon.entity.User;
import com.internship.falcon.filter.UserFilter;

import java.util.List;

public interface UserService {


    UserDto getUserById(Integer id);

    String addUser(User user);

    String updateUserById(Integer id, User user);

    String deleteUserById(Integer id);

    List<UserDto> getAllUsers();

    List<UserDto> getAllUsersPageableByUserSurname(int page, int size, String userSurname);

    long getNumberOfUsersBySurname(String userSurname);

    List<UserDto> getAllUsersPageable(int page, int size, String sortByUserSurname);

    long getNumberOfUsers();

    List<UserDto> getUsersByFilter(int page, int size, UserFilter userFilter);
}
