package kr.co.ch06.controller;

import kr.co.ch06.dto.User4DTO;
import kr.co.ch06.service.User4Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class User4Controller {
    private final User4Service user4Service;

    @GetMapping("/user4/register")
    public String register(){
        return "user4/register";
    }

    @PostMapping("/user4/register")
    public String register(User4DTO user4DTO){
        user4Service.register(user4DTO);
        return "redirect:/user4/list";
    }

    @GetMapping("/user4/list")
    public String list(Model model){
        List<User4DTO> dtoList = user4Service.getUser4s();
        model.addAttribute("dtoList", dtoList);
        return "user4/list";
    }

    @GetMapping("/user4/modify")
    public String modify(String name, Model model){
        User4DTO user4DTO = user4Service.getUser4(name);
        model.addAttribute(user4DTO);
        return "user4/modify";
    }

    @PostMapping("/user4/modify")
    public String modify(User4DTO user4DTO){
        user4Service.modify(user4DTO);
        return "redirect:/user4/list";
    }

    @GetMapping("/user4/delete")
    public String delete(String name){
        user4Service.delete(name);
        return "redirect:/user4/list";
    }
}
