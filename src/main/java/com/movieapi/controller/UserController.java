package com.movieapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.movieapi.model.User;
import com.movieapi.service.UserService;


/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */

@CrossOrigin(allowedHeaders="*",allowCredentials="true")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //get all user
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> usersList = userService.getUsersList();
        if (usersList.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
    }

    //get user by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    //add user
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user){
        User persistUser = userService.addUser(user);
        return new ResponseEntity<User>(persistUser,HttpStatus.CREATED);
    }

    //edit user
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<User> editUser(@RequestBody User user) {
        User existingUser = userService.getUserById(user.getId());
        if (existingUser == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        } else {
            User persistDriver = userService.editUser(user);
            return new ResponseEntity<User>(persistDriver,HttpStatus.OK);
        }
    }

    //delete user
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        User existingUser = userService.getUserById(id);
        if (existingUser == null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            userService.deleteUser(id);
            return new ResponseEntity<String>("Successfully deleted",HttpStatus.OK);
        }
    }
}
