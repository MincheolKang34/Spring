package kr.co.ch05.service;

import kr.co.ch05.dto.User2DTO;
import kr.co.ch05.mapper.User2Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User2Service {
    private final User2Mapper user2Mapper;

    public void registUser(User2DTO user2DTO) {
        user2Mapper.insertUser2(user2DTO);
    }

    public User2DTO getUserById(String user_id) {
        return user2Mapper.selectUser2(user_id);
    }

    public List<User2DTO> getAllUsers() {
        return user2Mapper.selectAllUser2();
    }

    public void modifyUser(User2DTO user2DTO) {
        user2Mapper.updateUser2(user2DTO);
    }

    public void deleteUser(String user_id) {
        user2Mapper.deleteUser2(user_id);
    }
}
