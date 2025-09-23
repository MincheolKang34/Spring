package kr.co.ch07.controller;

import kr.co.ch07.security.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = {"/", "/index"})
    public String index(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();

        return "index";
    }
}
