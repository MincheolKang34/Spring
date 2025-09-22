package kr.co.ch05.service;

import kr.co.ch05.dto.User6DTO;
import kr.co.ch05.mapper.User6Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class User6Service {
    private final User6Mapper user6Mapper;

    public void register(User6DTO user6DTO) {
        user6Mapper.insertUser6(user6DTO);
    }

    public User6DTO getUser6(int seq) {
        return user6Mapper.selectUser6BySeq(seq);
    }

    public List<User6DTO> getAllUser6() {
        return user6Mapper.selectAllUser6();
    }

    public void modifyUser6(User6DTO user6DTO) {
        user6Mapper.updateUser6(user6DTO);
    }

    public void deleteUser6(int seq) {
        user6Mapper.deleteUser6BySeq(seq);
    }

}
