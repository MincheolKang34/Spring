package kr.co.ch06.service;

import kr.co.ch06.dto.User3DTO;
import kr.co.ch06.entity.User3;
import kr.co.ch06.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class User3Service {
    private final User3Repository user3Repository;

    public void register(User3DTO user3DTO) {
        user3Repository.save(user3DTO.toEntity());
    }

    public User3DTO getUser3ById(String user_id) {
        Optional<User3> optUser3 = user3Repository.findById(user_id);
        if (optUser3.isPresent()) {
            return optUser3.get().toDTO();
        }
        return null;
    }

    public List<User3DTO> getUser3s() {
        List<User3> list = user3Repository.findAll();
        List<User3DTO> dtoList = list.stream()
                .map(user3 -> user3.toDTO())
                .collect(Collectors.toList());
        return dtoList;
    }

    public void modify(User3DTO user3DTO) {
        user3Repository.save(user3DTO.toEntity());
    }

    public void delete(String user_id) {
        user3Repository.deleteById(user_id);
    }
}
