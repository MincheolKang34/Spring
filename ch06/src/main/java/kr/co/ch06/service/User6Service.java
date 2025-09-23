package kr.co.ch06.service;

import kr.co.ch06.dto.User6DTO;
import kr.co.ch06.entity.User6;
import kr.co.ch06.repository.User6Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class User6Service {
    private final User6Repository user6Repository;

    public void register(User6DTO user6DTO) {
        user6Repository.save(user6DTO.toEntity());
    }
    public User6DTO getUser6(int seq) {
        Optional<User6> optUser6 = user6Repository.findById(seq);
        if (optUser6.isPresent()) {
            return optUser6.get().toDTO();
        }
        return null;
    }
    public List<User6DTO> getUser6s() {
        List<User6> user6s = user6Repository.findAll();
        List<User6DTO> dtoList = user6s.stream()
                .map(user6 -> user6.toDTO())
                .collect(Collectors.toList());
        return dtoList;
    }
    public void modify(User6DTO user6DTO) {
        user6Repository.save(user6DTO.toEntity());
    }
    public void delete(int seq) {
        user6Repository.deleteById(seq);
    }
}
