package kr.co.ch08.controller;

import kr.co.ch08.dto.User3DTO;
import kr.co.ch08.service.User3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class User3Controller {
    private final User3Service user3Service;

    @PostMapping("/user3")
    public ResponseEntity<User3DTO> register(@RequestBody User3DTO user3DTO) {
        User3DTO savedUser =  user3Service.register(user3DTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/user3/{userid}")
    public ResponseEntity<User3DTO> getUser(@PathVariable("userid") String userid) {
        User3DTO user3DTO = user3Service.getUser3(userid);
        return ResponseEntity.status(HttpStatus.OK).body(user3DTO);
    }

    @GetMapping("/user3")
    public ResponseEntity<List<User3DTO>> list() {
        List<User3DTO> dtoList = user3Service.getAllUser3();
        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }

    @PutMapping("/user3")
    public ResponseEntity<User3DTO> modify(@RequestBody User3DTO user3DTO) {
        User3DTO modifiedUser =  user3Service.modify(user3DTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(modifiedUser);
    }

    @DeleteMapping("/user3/{userid}")
    public ResponseEntity<Boolean> delete(@PathVariable("userid") String userid) {
        boolean isSuccess = user3Service.deleteUser3(userid);
        return ResponseEntity.status(HttpStatus.OK).body(isSuccess);
    }
}
