package kr.co.ch04.dao;

import kr.co.ch04.dto.User1DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 클래스를 객체로 생성 -> 컨테이너에 등록
@RequiredArgsConstructor
public class User1DAO {
    private final JdbcTemplate jdbcTemplate;

    public void insert(User1DTO user1DTO){
        String sql = "INSERT INTO USER1 VALUES (?,?,?,?)";

        Object[] params = {
                user1DTO.getUserId(),
                user1DTO.getUserName(),
                user1DTO.getBirth(),
                user1DTO.getAge()
        };

        jdbcTemplate.update(sql, params);
    }
    public User1DTO select(String userId){
        String sql = "SELECT * FROM USER1 WHERE USERID = ?";
        return jdbcTemplate.queryForObject(sql, new User1RowMapper(), userId);
    }
    public List<User1DTO> selectAll(){
        String sql = "SELECT * FROM USER1";
        return jdbcTemplate.query(sql, new User1RowMapper());
    }
    public void update(User1DTO user1DTO){
        String sql = "UPDATE USER1 SET username=?, birth=?, age=? WHERE userid=?";
        Object[] params = {
                user1DTO.getUserName(),
                user1DTO.getBirth(),
                user1DTO.getAge(),
                user1DTO.getUserId()
        };

        jdbcTemplate.update(sql, params);
    }
    public void delete(String  userId){
        String sql = "DELETE FROM USER1 WHERE USERID = ?";
        jdbcTemplate.update(sql, userId);
    }
}
