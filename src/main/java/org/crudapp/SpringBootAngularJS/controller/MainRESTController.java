package org.crudapp.SpringBootAngularJS.controller;

import org.crudapp.SpringBootAngularJS.dao.UserDAO;
import org.crudapp.SpringBootAngularJS.model.User;
import org.crudapp.SpringBootAngularJS.model.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRESTController {
    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "/user", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
    @ResponseBody
    public List<User> getUsers() {
        List<User> list = userDAO.getAllUsers();
        return list;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public User getUser(@PathVariable("id") Long id) {
        return userDAO.getUserById(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    @PostMapping("/user")
    @ResponseBody
    public User addUser(@RequestBody UserForm newUser) {
        if (newUser.getNo() != null && newUser.getName() != null) {
            return userDAO.addUser(newUser);
        } else {
            throw new NullPointerException();
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public User updateUser(@RequestBody User formUser) {
        return userDAO.updateUser(formUser);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteUser(@PathVariable("id") Long id) {
        userDAO.deleteUser(id);
    }
}