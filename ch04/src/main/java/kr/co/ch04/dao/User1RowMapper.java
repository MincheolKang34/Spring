package kr.co.ch04.dao;

import kr.co.ch04.dto.User1DTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User1RowMapper implements RowMapper<User1DTO> {
    @Override
    public User1DTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        User1DTO userDTO = new User1DTO();
        userDTO.setUserId(rs.getString("USERID"));
        userDTO.setUserName(rs.getString("USERNAME"));
        userDTO.setBirth(rs.getString("BIRTH"));
        userDTO.setAge(rs.getInt("AGE"));

        return userDTO;
    }
}
