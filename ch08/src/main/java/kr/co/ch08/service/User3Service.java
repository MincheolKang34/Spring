package kr.co.ch08.service;

import kr.co.ch08.dto.User3DTO;
import kr.co.ch08.entity.User3;
import kr.co.ch08.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class User3Service {
    private final User3Repository user3Repository;

    public User3DTO register(User3DTO user3DTO) {
        User3 savedUser = user3Repository.save(user3DTO.toEntity());
        return savedUser.toDTO();
    }

    public User3DTO getUser3(String userid) {
        Optional<User3> user3 = user3Repository.findById(userid);
        if (user3.isPresent()) {
            return user3.get().toDTO();
        }
        return null;
    }

    public List<User3DTO> getAllUser3() {
        List<User3> user3s = user3Repository.findAll();
        return user3s.stream()
                .map(user3 -> user3.toDTO())
                .toList();
    }

    public User3DTO modify(User3DTO user3DTO) {
        User3 user3 = user3DTO.toEntity();
        log.info("user entity: "+ user3.toString());
        if (user3Repository.existsById(user3.getUserid())) {
            User3 modifiedUser = user3Repository.save(user3);
            log.info(modifiedUser.toString());
            return modifiedUser.toDTO();
        }
        return null;
    }

    public boolean deleteUser3(String userid) {
        if (user3Repository.existsById(userid)) {
            user3Repository.deleteById(userid);
            return true;
        }
        return false;
    }
}
