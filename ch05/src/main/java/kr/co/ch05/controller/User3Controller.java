package kr.co.ch05.controller;

import kr.co.ch05.dto.User3DTO;
import kr.co.ch05.service.User3Service;
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
    public String regist() {
        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String regist(User3DTO user3DTO) {
        user3Service.registUser3(user3DTO);
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/list")
    public String list(Model model) {
        user3Service.getAllUser3();

        List<User3DTO> dtoList = user3Service.getAllUser3();
        model.addAttribute("dtoList", dtoList);

        return "/user3/list";
    }

    @GetMapping("/user3/modify")
    public String modify(String user_id, Model model) {
        User3DTO user3DTO = user3Service.getUser3ById(user_id);
        model.addAttribute("user3DTO", user3DTO);
        return "/user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(User3DTO user3DTO) {
        user3Service.modifyUser3(user3DTO);
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/delete")
    public String delete(String user_id) {
        user3Service.deleteUser3(user_id);
        return "redirect:/user3/list";
    }
}
