package kr.co.ch06.controller;

import kr.co.ch06.dto.User3DTO;
import kr.co.ch06.entity.User3;
import kr.co.ch06.service.User3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class User3Controller {
    private final User3Service user3Service;

    @GetMapping("/user3/register")
    public String register(){
        return "user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO user3DTO){
        user3Service.register(user3DTO);
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/list")
    public String list(Model model){
        List<User3DTO> dtoList = user3Service.getUser3s();
        model.addAttribute("dtoList",dtoList);
        return "user3/list";
    }

    @GetMapping("/user3/modify")
    public String modify(String user_id, Model model){
        User3DTO user3DTO = user3Service.getUser3ById(user_id);
        model.addAttribute("user3DTO",user3DTO);
        return "user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(User3DTO user3DTO){
        user3Service.modify(user3DTO);
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/delete")
    public String delete(String user_id){
        user3Service.delete(user_id);
        return "redirect:/user3/list";
    }
}
