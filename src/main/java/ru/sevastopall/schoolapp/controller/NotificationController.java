package ru.sevastopall.schoolapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.service.NotificationService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/all")
    public String getMessageList(Model model, HttpSession session) {
        model.addAttribute("notifications", notificationService.findByUser((User) session.getAttribute("user")));
        return "/notification/all";
    }
}
