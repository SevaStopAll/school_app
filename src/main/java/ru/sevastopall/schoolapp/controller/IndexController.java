package ru.sevastopall.schoolapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.service.NewsService;
import ru.sevastopall.schoolapp.service.NotificationService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class IndexController {
    private final NewsService newsService;
    private final NotificationService notificationService;


    @GetMapping("/")
    public String getClassCreationPage(Model model, HttpSession session) {
        model.addAttribute("news", newsService.findAll());
        model.addAttribute("notifications", notificationService.findByUser((User) session.getAttribute("user")));
        return "index";
    }
}
