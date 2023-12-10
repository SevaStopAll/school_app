package ru.sevastopall.schoolapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sevastopall.schoolapp.domain.ChatMessage;
import ru.sevastopall.schoolapp.domain.Message;
import ru.sevastopall.schoolapp.domain.Notification;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/messenger")
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final ChatService chatService;
    private final UserService userService;
    private final ChatMessageService chatMessageService;
    private final NotificationService notificationService;

    @GetMapping("/messages/all")
    public String getMessageList(Model model, HttpSession session) {
        model.addAttribute("messages", messageService.findByReceiver((User) session.getAttribute("user")));
        model.addAttribute("chats", chatService.findByParticipantsContaining((User) session.getAttribute("user")));
        model.addAttribute("users", userService.findAll());
        return "/messenger/messages/all";
    }

    @GetMapping("/chats/{id}")
    public String getChat(Model model, @PathVariable long id) {
        List<ChatMessage> messages = chatMessageService.findByChat(chatService.findById(id));
        model.addAttribute("chatMessages", messages);
        model.addAttribute("chatId", id);
        return "/messenger/chats/one";
    }

    @PostMapping("/messages/create")
    public String saveSubject(@ModelAttribute Message message, String[] receiverId, HttpSession session) {
        User userSender = (User) session.getAttribute("user");
        message.setSender(userService.findById(userSender.getId()).get());
        User userReciever = userService.findById(Integer.parseInt(receiverId[0])).get();
        LocalDateTime timestamp = LocalDateTime.now();
        message.setReceiver(userReciever);
        message.setTimestamp(timestamp);
        messageService.save(message);
        notificationService.save(Notification.builder()
                        .text("You have a new message from " + userSender.getFirstName() + userSender.getLastName())
                        .timestamp(timestamp)
                        .user(userReciever)
                .build());
        return "redirect:/messenger/messages/all";
    }

    @PostMapping("/chats/createMessage")
    public String saveChatMessage(@ModelAttribute ChatMessage message, HttpSession httpSession, long chatId, Model model) {
        User userSender = (User) httpSession.getAttribute("user");
        message.setSender(userSender);
        message.setChat(chatService.findById(chatId));
        message.setTimestamp(LocalDateTime.now());
        chatMessageService.save(message);
        chatService.findById(chatId).getParticipants().forEach(user -> {
            notificationService.save(Notification.builder()
                    .text("You have a new message from in group chat" + userSender.getFirstName() + userSender.getLastName())
                    .timestamp(LocalDateTime.now())
                    .user(user)
                    .build());
        });
        return "redirect:/messenger/chats/" + chatId;
    }
}

