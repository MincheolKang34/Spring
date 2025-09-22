package kr.co.ch05.service;

import kr.co.ch05.dto.User7DTO;
import kr.co.ch05.mapper.User7Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User7Service {
    private final User7Mapper user7Mapper;

    public void register(User7DTO user7DTO) {
        user7Mapper.insertUser7(user7DTO);
    }
    public User7DTO findById(int id) {
        return user7Mapper.selectUser7ById(id);
    }
    public List<User7DTO> findAllUser7() {
        return user7Mapper.selectAllUser7();
    }
    public void modifyUser7(User7DTO user7DTO) {
        user7Mapper.updateUser7(user7DTO);
    }
    public void deleteUser7(int id) {
        user7Mapper.deleteUser7(id);
    }
}
