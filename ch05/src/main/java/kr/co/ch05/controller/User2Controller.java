package kr.co.ch05.controller;

import kr.co.ch05.dto.User2DTO;
import kr.co.ch05.service.User2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class User2Controller {
    private final User2Service user2Service;

    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO){
        user2Service.registUser(user2DTO);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/list")
    public String list(Model model){
        List<User2DTO> dtoList = user2Service.getAllUsers();

        model.addAttribute("dtoList",dtoList);

        return "/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@RequestParam("user_id") String user_id, Model model) {
        User2DTO dto = user2Service.getUserById(user_id);
        model.addAttribute("user2DTO",dto);
        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO user2DTO) {
        user2Service.modifyUser(user2DTO);
        return "redirect:/user2/list";
    }

    @GetMapping("user2/delete")
    public String delete(@RequestParam("user_id") String user_id) {
        user2Service.deleteUser(user_id);
        return "redirect:/user2/list";
    }
}
