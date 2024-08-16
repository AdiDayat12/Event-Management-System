package com.practice.event_management_system.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordService {
    public String hashPassword (String pass){
        return BCrypt.hashpw(pass, BCrypt.gensalt());
    }
}
