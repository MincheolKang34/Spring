package kr.co.ch05.service;

import kr.co.ch05.dto.User3DTO;
import kr.co.ch05.mapper.User3Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User3Service {
    private final User3Mapper user3Mapper;

    public void registUser3(User3DTO user3DTO) {
        user3Mapper.insertUser3(user3DTO);
    }

    public User3DTO getUser3ById(String user_id) {
        return user3Mapper.selectUser3(user_id);
    }

    public List<User3DTO> getAllUser3() {
        return user3Mapper.selectAllUser3();
    }

    public void modifyUser3(User3DTO user3DTO) {
        user3Mapper.updateUser3(user3DTO);
    }

    public void deleteUser3(String user_id) {
        user3Mapper.deleteUser3(user_id);
    }
}
