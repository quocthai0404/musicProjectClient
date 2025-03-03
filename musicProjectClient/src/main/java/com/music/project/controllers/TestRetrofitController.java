package com.music.project.controllers;


import com.music.project.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestRetrofitController {
    @Autowired
    private TestService testService;

    @GetMapping("/index")
    public String index() {
        return "test/index";
    }

    @GetMapping("/process")
    public String process(ModelMap modelMap) {
        String result = testService.test();
        modelMap.addAttribute("result", result);
        return "test/result";
    }
}
