package kr.co.ch06.controller;

import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service user1Service;

    @GetMapping("/user1/list")
    public String list(Model model) {
        List<User1DTO> dtoList = user1Service.getUsers();
        model.addAttribute("dtoList", dtoList);
        return "user1/list";
    }

    @GetMapping("/user1/register")
    public String register() {
        return "user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO) {
        log.info(user1DTO.toString());
        user1Service.save(user1DTO);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(String userId, Model model) {
        User1DTO user1DTO = user1Service.getUser(userId);
        model.addAttribute(user1DTO);
        return "user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO user1DTO) {
        user1Service.modify(user1DTO);
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
    public String delete(String userId) {
        user1Service.delete(userId);
        return "redirect:/user1/list";
    }
}
