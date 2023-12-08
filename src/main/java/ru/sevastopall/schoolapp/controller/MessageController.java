package ru.sevastopall.schoolapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sevastopall.schoolapp.domain.ChatMessage;
import ru.sevastopall.schoolapp.domain.Message;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.service.ChatMessageService;
import ru.sevastopall.schoolapp.service.ChatService;
import ru.sevastopall.schoolapp.service.MessageService;
import ru.sevastopall.schoolapp.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/messenger")
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final ChatService chatService;
    private final UserService userService;
    private final ChatMessageService chatMessageService;

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
        return "/messenger/chats/one";
    }

    @PostMapping("/messages/create")
    public String saveSubject(@ModelAttribute Message message, String[] usersIds) {
        message.setReceiver(userService.findById(Integer.parseInt(usersIds[0])).get());
        messageService.save(message);
        return "redirect:/";
    }
}

