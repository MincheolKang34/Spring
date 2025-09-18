package kr.co.ch05.service;

import kr.co.ch05.dto.User4DTO;
import kr.co.ch05.mapper.User4Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User4Service {
    private final User4Mapper user4Mapper;

    public void registerUser4(User4DTO user4DTO) {
        user4Mapper.insertUser4(user4DTO);
    }

    public User4DTO getUser4(String name) {
        return user4Mapper.selectUser4(name);
    }

    public List<User4DTO> getAllUser4() {
        return user4Mapper.selectAllUser4();
    }

    public void modifyUser4(User4DTO user4DTO) {
        user4Mapper.updateUser4(user4DTO);
    }

    public void deleteUser4(String name) {
        user4Mapper.deleteUser4(name);
    }
}
