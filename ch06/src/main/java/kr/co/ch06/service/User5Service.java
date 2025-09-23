package kr.co.ch06.service;

import kr.co.ch06.dto.User5DTO;
import kr.co.ch06.entity.User5;
import kr.co.ch06.repository.User5Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class User5Service {
    private final User5Repository user5Repository;

    public void register(User5DTO user5DTO) {
        user5Repository.save(user5DTO.toEntity());
    }
    public User5DTO getUser5(String name) {
        Optional<User5> optUser5 = user5Repository.findById(name);
        if (optUser5.isPresent()) {
            return optUser5.get().toDTO();
        }
        return null;
    }
    public List<User5DTO> getUser5s() {
        List<User5> user5s = user5Repository.findAll();
        List<User5DTO> dtoList = user5s.stream()
                .map(user5 -> user5.toDTO())
                .collect(Collectors.toList());
        return dtoList;
    }
    public void modify(User5DTO user5DTO) {
        user5Repository.save(user5DTO.toEntity());
    }
    public void delete(String name) {
        user5Repository.deleteById(name);
    }
}
