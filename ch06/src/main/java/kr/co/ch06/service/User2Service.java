package kr.co.ch06.service;

import kr.co.ch06.dto.User2DTO;
import kr.co.ch06.entity.User2;
import kr.co.ch06.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class User2Service {
    private final User2Repository user2Repository;

    public void register(User2DTO user2DTO) {
        user2Repository.save(user2DTO.toEntity());
    }
    public User2DTO findByUserId(String user_id) {
        Optional<User2> optUser2 = user2Repository.findById(user_id);
        if(optUser2.isPresent()){
            User2 user2 = optUser2.get();
            return user2.toDTO();
        }
        return null;
    }
    public List<User2DTO> findAll() {
        List<User2> list = user2Repository.findAll();
        List<User2DTO> dtoList = list.stream()
                .map(entity -> entity.toDTO())
                .collect(Collectors.toList());

        return dtoList;
    }
    public void modify(User2DTO user2DTO) {
        user2Repository.save(user2DTO.toEntity());
    }
    public void delete(String user_id) {
        user2Repository.deleteById(user_id);
    }
}
