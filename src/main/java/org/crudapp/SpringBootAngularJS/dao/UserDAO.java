package org.crudapp.SpringBootAngularJS.dao;

import org.crudapp.SpringBootAngularJS.model.User;
import org.crudapp.SpringBootAngularJS.model.UserForm;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class UserDAO {
    private static final Map<Long, User> users = new HashMap<>();

    @PostConstruct
    private void initUsers() {
        User user1 = new User(1L, "E01", "Smith", "Cleck");
        User user2 = new User(2L, "E02", "Allen", "Salesman");
        User user3 = new User(3L, "E03", "Jones", "Manager");
        users.put(user1.getId(), user1);
        users.put(user2.getId(), user2);
        users.put(user3.getId(), user3);
    }

    public Long getMaxUserId() {
        Set<Long> keys = users.keySet();
        Long max = 1L;
        for (Long key : keys) {
            if (key > max) {
                max = key;
            }
        }
        return max;
    }

    public User getUserById(Long id) {
        return users.get(id);
    }

    public User addUser(UserForm user) {
        Long empId = this.getMaxUserId() + 1;
        user.setId(empId);
        User newUser = new User(user);
        users.put(newUser.getId(), newUser);
        return newUser;

    }

    public User updateUser(User employeeForm) {

        User emp = users.get(employeeForm.getId());
        if (emp != null) {
            emp.setNo(employeeForm.getNo());
            emp.setName(employeeForm.getName());
            emp.setPosition(employeeForm.getPosition());
        }
        return emp;
    }

    public void deleteUser(Long empId) {
        users.remove(empId);
    }

    public List<User> getAllUsers() {
        Collection<User> c = users.values();
        List<User> list = new ArrayList<>();
        list.addAll(c);
        return list;
    }
}