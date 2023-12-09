package ru.sevastopall.schoolapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sevastopall.schoolapp.domain.News;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.service.NewsService;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class NewsController {

    private final NewsService newsService;


    @GetMapping("/news/create")
    public String getCreationPage() {
        return "admin/news/create";
    }

    @PostMapping("/news/create")
    public String saveNews(@ModelAttribute News news, HttpSession session) {
        news.setUser((User)session.getAttribute("user"));
        newsService.save(news);
        return "redirect:/";
    }

    @GetMapping("/news/{id}")
    public String getNewsDetails(Model model, @PathVariable int id) {
        News news = newsService.findById(id);
        model.addAttribute("news", news);
        return "admin/news/one";
    }
}
