package kr.co.ch08.controller;

import jakarta.validation.Valid;
import kr.co.ch08.dto.User2DTO;
import kr.co.ch08.service.User2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class User2Controller {
    private final User2Service user2Service;

    @PostMapping("/user2")
    public ResponseEntity<User2DTO> register(@Valid @RequestBody User2DTO user2DTO) {
        log.info("User2DTO: {}", user2DTO);
        User2DTO savedUser = user2Service.register(user2DTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @GetMapping("/user2/{userid}")
    public ResponseEntity<User2DTO> user2(@PathVariable("userid") String userid) {
        log.info("userid {}", userid);
        User2DTO user2DTO = user2Service.getUser2ById(userid);
        return ResponseEntity.status(HttpStatus.OK).body(user2DTO);
    }

    @GetMapping("/user2")
    public ResponseEntity<List<User2DTO>> list() {
        List<User2DTO> dtoList = user2Service.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }

    @PutMapping("/user2")
    public ResponseEntity<User2DTO> modify(@Valid @RequestBody User2DTO user2DTO) {
        log.info("user2DTO {}", user2DTO);
        User2DTO modifiedUser = user2Service.modify(user2DTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(modifiedUser);
    }

    @DeleteMapping("/user2/{userid}")
    public ResponseEntity<Boolean> delete(@PathVariable("userid") String userid) {
        log.info("userid {}", userid);
        boolean isSuccess = user2Service.delete(userid);
        return ResponseEntity.status(HttpStatus.OK).body(isSuccess);
    }
}
