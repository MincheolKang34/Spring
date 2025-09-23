package kr.co.ch06.service;

import kr.co.ch06.dto.User7DTO;
import kr.co.ch06.entity.User7;
import kr.co.ch06.repository.User7Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class User7Service {
    private final User7Repository user7Repository;

    public void register(User7DTO user7DTO) {
        user7Repository.save(user7DTO.toEntity());
    }
    public User7DTO getUser7(int id) {
        Optional<User7> optUser7 = user7Repository.findById(id);
        if (optUser7.isPresent()) {
            return optUser7.get().toDTO();
        }
        return null;
    }
    public List<User7DTO> getUser7s() {
        List<User7> user7s = user7Repository.findAll();
        List<User7DTO> dtoList = user7s.stream()
                .map(user7 -> user7.toDTO())
                .collect(Collectors.toList());
        return dtoList;
    }
    public void modify(User7DTO user7DTO) {
        user7Repository.save(user7DTO.toEntity());
    }
    public void delete(int id) {
        user7Repository.deleteById(id);
    }
}
