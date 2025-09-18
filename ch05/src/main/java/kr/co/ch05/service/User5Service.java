package kr.co.ch05.service;

import kr.co.ch05.dto.User5DTO;
import kr.co.ch05.mapper.User5Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User5Service {
    private final User5Mapper user5Mapper;

    public void registerUser5(User5DTO user5DTO) {
        user5Mapper.insertUser5(user5DTO);
    }

    public User5DTO getUser5(String name) {
        return user5Mapper.selectUser5(name);
    }

    public List<User5DTO> getAllUser5() {
        return user5Mapper.selectAllUser5();
    }

    public void modifyUser5(User5DTO user5DTO) {
        user5Mapper.updateUser5(user5DTO);
    }

    public void deleteUser5(String name) {
        user5Mapper.deleteUser5(name);
    }
}
