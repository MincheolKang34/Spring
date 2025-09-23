package kr.co.ch06.service;

import kr.co.ch06.dto.User4DTO;
import kr.co.ch06.entity.User4;
import kr.co.ch06.repository.User4Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class User4Service {
    private final User4Repository user4Repository;

    public void register(User4DTO user4DTO) {
        user4Repository.save(user4DTO.toEntity());
    }

    public User4DTO getUser4(String name) {
        Optional<User4> optUser4 = user4Repository.findById(name);
        if (optUser4.isPresent()) {
            return optUser4.get().toDTO();
        }
        return null;
    }

    public List<User4DTO> getUser4s() {
        List<User4> user4s = user4Repository.findAll();
        List<User4DTO> dtoList = user4s.stream()
                .map(user4 -> user4.toDTO())
                .collect(Collectors.toList());
        return dtoList;
    }

    public void modify(User4DTO user4DTO) {
        user4Repository.save(user4DTO.toEntity());
    }

    public void delete(String name) {
        user4Repository.deleteById(name);
    }
}
