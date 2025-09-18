package kr.co.ch05.controller;

import kr.co.ch05.dto.User5DTO;
import kr.co.ch05.service.User5Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class User5Controller {
    private final User5Service user5Service;

    @GetMapping("/user5/register")
    public String register(){
        return "/user5/register";
    }

    @PostMapping("/user5/register")
    public String register(User5DTO user5DTO){
        user5Service.registerUser5(user5DTO);
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/list")
    public String list(Model model){
        List<User5DTO> dtoList = user5Service.getAllUser5();
        model.addAttribute("dtoList",dtoList);
        return "/user5/list";
    }
}
