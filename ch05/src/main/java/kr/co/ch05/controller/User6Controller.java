package kr.co.ch05.controller;

import kr.co.ch05.dto.User6DTO;
import kr.co.ch05.service.User6Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class User6Controller {
    private final User6Service user6Service;

    @GetMapping("/user6/register")
    public String register(){
        return "user6/register";
    }

    @PostMapping("/user6/register")
    public String register(User6DTO user6DTO){
        user6Service.register(user6DTO);
        return "redirect:/user6/list";
    }

    @GetMapping("/user6/list")
    public String list(Model model){
        List<User6DTO> dtoList = user6Service.getAllUser6();
        model.addAttribute("dtoList",dtoList);
        return "user6/list";
    }

    @GetMapping("/user6/modify")
    public String modify(int seq, Model model){
        User6DTO user6DTO = user6Service.getUser6(seq);
        model.addAttribute("user6DTO",user6DTO);
        return "user6/modify";
    }

    @PostMapping("/user6/modify")
    public String modify(User6DTO user6DTO){
        user6Service.modifyUser6(user6DTO);
        return "redirect:/user6/list";
    }

    @GetMapping("/user6/delete")
    public String delete(int seq){
        user6Service.deleteUser6(seq);
        return "redirect:/user6/list";
    }
}
