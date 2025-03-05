package com.music.project.controllers;


import com.music.project.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {
    @Autowired
    private TestService testService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("activePage", "home/index");
        return "index";
    }
    @GetMapping("/process")
    public String process(ModelMap modelMap) {
        String result = testService.test();
        modelMap.addAttribute("result", result);
        return "home/result";
    }
    @GetMapping("/explore")
    public String explore() {
        return "explore"; // Trả về explore.html
    }
}
