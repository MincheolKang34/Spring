package kr.co.ch08.service;

import kr.co.ch08.dto.User2DTO;
import kr.co.ch08.entity.User2;
import kr.co.ch08.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class User2Service {
    private final User2Repository user2Repository;

    public User2DTO register(User2DTO user2DTO) {
        log.info("User2DTO: {}", user2DTO);
        User2 user2 = user2Repository.save(user2DTO.toEntity());
        return user2.toDTO();
    }

    public List<User2DTO> getAllUsers() {
        List<User2> user2s = user2Repository.findAll();
        return user2s.stream()
                .map(user2 -> user2.toDTO())
                .toList();
    }

    public User2DTO getUser2ById(String userid) {
        Optional<User2> user2 = user2Repository.findById(userid);
        if (user2.isPresent()) {
            return user2.get().toDTO();
        }
        return null;
    }

    public User2DTO modify(User2DTO user2DTO) {
        log.info("User2DTO: {}", user2DTO);
        User2 user2 = user2DTO.toEntity();
        if (user2Repository.existsById(user2.getUserid())) {
            User2 modifiedUser = user2Repository.save(user2);
            return modifiedUser.toDTO();
        }
        return null;
    }

    public boolean delete(String userid) {
        if (user2Repository.existsById(userid)) {
            user2Repository.deleteById(userid);
            return true;
        }
        return false;
    }
}
