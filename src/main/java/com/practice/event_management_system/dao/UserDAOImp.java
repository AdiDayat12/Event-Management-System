package com.practice.event_management_system.dao;

import com.practice.event_management_system.model.User;
import com.practice.event_management_system.util.ConnectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

@Slf4j
public class UserDAOImp implements UserDAO{
    @Override
    public int createUser(User user) {
        String sql = """
                INSERT INTO user (userID, username, date_of_birth, email, password)
                values  ?, ?, ?, ?, ?""";
        int result = 0;
        try (Connection conn = ConnectionUtil.getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getId().toString());
            ps.setString(2, user.getUsername());
            ps.setDate(3, Date.valueOf(user.getDateOfBirth()));
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPass());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error {}", e.getMessage());
        }
        return result;
    }


    @Override
    public int updateUser(String fullName, String email) {
        return 0;
    }

    @Override
    public int deleteUser(String fullName, String email) {
        return 0;
    }

    @Override
    public User getUserByID(String id) {
        return null;
    }
}
