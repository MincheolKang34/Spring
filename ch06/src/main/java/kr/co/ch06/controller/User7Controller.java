package kr.co.ch06.controller;

import kr.co.ch06.dto.User7DTO;
import kr.co.ch06.service.User7Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class User7Controller {
    private final User7Service user7Service;

    @GetMapping("/user7/register")
    public String register(){
        return "user7/register";
    }

    @PostMapping("/user7/register")
    public String register(User7DTO user7DTO){
        user7Service.register(user7DTO);
        return "redirect:/user7/list";
    }

    @GetMapping("/user7/list")
    public String list(Model model){
        List<User7DTO> dtoList = user7Service.getUser7s();
        model.addAttribute("dtoList", dtoList);
        return "user7/list";
    }

    @GetMapping("/user7/modify")
    public String modify(int id, Model model){
        User7DTO user7DTO = user7Service.getUser7(id);
        model.addAttribute("user7DTO", user7DTO);
        return "user7/modify";
    }

    @PostMapping("/user7/modify")
    public String modify(User7DTO user7DTO){
        user7Service.modify(user7DTO);
        return "redirect:/user7/list";
    }

    @GetMapping("/user7/delete")
    public String delete(int id){
        user7Service.delete(id);
        return "redirect:/user7/list";
    }
}
