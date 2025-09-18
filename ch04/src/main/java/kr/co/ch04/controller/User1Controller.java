package kr.co.ch04.controller;

import kr.co.ch04.dto.User1DTO;
import kr.co.ch04.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class User1Controller {

    private final User1Service service;

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO){
        log.debug(user1DTO.toString());
        return "/user1/register";
    }

    @GetMapping("/user1/list")
    public String list(Model model){

        List<User1DTO> dtoList = service.getUsers();

        model.addAttribute("dtoList",dtoList);

        return "/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(){
        return "/user1/modify";
    }

    @GetMapping("/user1/delete")
    public String delete(String userId){
        return "/user1/delete";
    }
}
