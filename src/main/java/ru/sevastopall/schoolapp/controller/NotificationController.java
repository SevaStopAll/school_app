package ru.sevastopall.schoolapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.schoolapp.domain.Notification;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.service.NotificationService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/notification")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/all")
    public String getMessageList(Model model, HttpSession session) {
        List<Notification> userNotifications = notificationService.findByUser((User) session.getAttribute("user"));
        model.addAttribute("notifications", userNotifications);
        userNotifications.stream().peek(notification -> notification.setRead(true)).forEach(notificationService::save);
        return "/notification/all";
    }
}
