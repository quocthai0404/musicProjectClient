package com.music.project.controllers;

import com.music.project.models.SongResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class RootController {
    private final String API_URL = "http://localhost:8085/api/songs/getAll?page=0&size=5";

    @GetMapping("/")
    public String redirectToHome(Model model) {
        model.addAttribute("activePage", "home/index"); // Đặt trạng thái active

        // Gọi API lấy danh sách bài hát
        RestTemplate restTemplate = new RestTemplate();
        SongResponse response = restTemplate.getForObject(API_URL, SongResponse.class);

        // Kiểm tra response có dữ liệu không
        if (response != null && response.getContent() != null) {
            model.addAttribute("songs", response.getContent()); // Đưa danh sách bài hát vào model
        } else {
            model.addAttribute("songs", List.of()); // Nếu không có dữ liệu, gán danh sách rỗng
        }

        return "index"; // Trả về trang index.html
    }
}
