package com.internship.falcon.controller;

import com.internship.falcon.dto.UserDto;
import com.internship.falcon.entity.User;
import com.internship.falcon.filter.UserFilter;
import com.internship.falcon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("get")
    public UserDto getUserById(@RequestParam Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("get/pagingByUserSurname")
    public List<UserDto> getAllUsersPageableByUserSurname(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "5") int size,
                                             @RequestParam String userSurname){
        return userService.getAllUsersPageableByUserSurname(page,size, userSurname);
    }
    @GetMapping("get/paging")
    public List<UserDto> getAllUsersPageable(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "5") int size,
                                             @RequestParam(defaultValue = "true") String sortByUserSurname){
        return userService.getAllUsersPageable(page,size, sortByUserSurname);
    }

    @GetMapping("get/filter")
    public List<UserDto> getUsersByFilter(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "5") int size,
                                          @RequestBody UserFilter userFilter){
        return userService.getUsersByFilter(page, size, userFilter);
    }

    @GetMapping("get/numberOfUsers")
    public long getNumberOfUsers(){
        return userService.getNumberOfUsers();
    }

    @GetMapping("get/numberOfUsersBySurname")
    public long getNumberOfUsersBySurname(@RequestParam String userSurname){
        return userService.getNumberOfUsersBySurname(userSurname);
    }

    @GetMapping("get/all")
    public List<UserDto> getAllUsers(){
        return  userService.getAllUsers();
    }


    @PostMapping("add")
    public String addUser(@RequestBody User user){

        return userService.addUser(user);
    }


    @PutMapping("update")
    public String updateUserById(@RequestParam Integer id, @RequestBody User user){
        return  userService.updateUserById(id, user);
    }

    @DeleteMapping("delete")
    public String deleteUserById(@RequestParam Integer id){
        return userService.deleteUserById(id);
    }


}
