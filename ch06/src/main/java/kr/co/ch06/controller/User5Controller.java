package kr.co.ch06.controller;

import kr.co.ch06.dto.User5DTO;
import kr.co.ch06.service.User5Service;
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
        return "user5/register";
    }

    @PostMapping("/user5/register")
    public String register(User5DTO user5DTO){
        user5Service.register(user5DTO);
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/list")
    public String list(Model model){
        List<User5DTO> dtoList = user5Service.getUser5s();
        model.addAttribute("dtoList",dtoList);
        return "user5/list";
    }

    @GetMapping("/user5/modify")
    public String modify(String name, Model model){
        User5DTO user5DTO = user5Service.getUser5(name);
        model.addAttribute("user5DTO",user5DTO);
        return "user5/modify";
    }

    @PostMapping("/user5/modify")
    public String modify(User5DTO user5DTO){
        user5Service.modify(user5DTO);
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/delete")
    public String delete(String name){
        user5Service.delete(name);
        return "redirect:/user5/list";
    }
}
