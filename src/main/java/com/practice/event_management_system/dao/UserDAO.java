package com.practice.event_management_system.dao;


import com.practice.event_management_system.model.User;

public interface UserDAO {
    int createUser (User user);
    int updateUser (String fullName, String email);
    int deleteUser (String fullName, String email);
    User getUserByID (String id);
}
