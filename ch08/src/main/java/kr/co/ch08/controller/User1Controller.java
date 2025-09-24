package kr.co.ch08.controller;

import kr.co.ch08.dto.User1DTO;
import kr.co.ch08.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class User1Controller {
    private final User1Service user1Service;

    @ResponseBody // 요청 메서드의 반환값을 View로 출력하지 않고 응답객체 Response body로 출력.
    @GetMapping("/user1")
    public List<User1DTO> list(){
        List<User1DTO> dtoList = user1Service.getUserAll();
        return dtoList;
    }

    @ResponseBody
    @GetMapping("/user1/{userid}")
    public User1DTO user1(@PathVariable("userid") String userid){
        log.info("user1 ==> userid={}", userid);
        User1DTO user1DTO = user1Service.getUser(userid);

        return user1DTO;
    }

    @ResponseBody
    @PostMapping("/user1")
    public String register(User1DTO user1DTO){

        log.info("user1DTO:{}",user1DTO);

        user1Service.save(user1DTO);

        return "success";
    }

    @ResponseBody
    @PutMapping("/user1")
    public String modify(@RequestBody User1DTO user1DTO){ // @RequestBody : 요청 객체 body로 전송되는 JSON 데이터 수신
        log.info("user1DTO:{}",user1DTO);
        user1Service.modify(user1DTO);
        return "modified";
    }

    @ResponseBody
    @DeleteMapping("/user1/{userid}")
    public String delete(@PathVariable("userid") String userid){
        log.info("user1 ==> userid={}", userid);
        user1Service.remove(userid);
        return "deleted";
    }
}
