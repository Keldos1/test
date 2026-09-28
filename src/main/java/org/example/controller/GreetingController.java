package org.example.controller;


import org.example.dto.UsersMainDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"user"})
public class GreetingController {
    @GetMapping("/hello/{id}")
    public String hello(
            @RequestParam Integer age,
            @RequestHeader String accept,
            @CookieValue("JSESSIONID") String jsessionid,
            @PathVariable("id") Integer id,
            Model model,
            UsersMainDto userReadDto) {


        model.addAttribute("user", userReadDto);
        return "greeting/hello";
    }

    @GetMapping("/bye")
    public String bye(ModelAndView mv, @SessionAttribute("user") UsersMainDto user) {
        mv.setViewName("greeting/bye");
        return "greeting/bye";
    }
}