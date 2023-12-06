package ru.sevastopall.schoolapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.schoolapp.domain.ChatMessage;
import ru.sevastopall.schoolapp.domain.SchoolDay;
import ru.sevastopall.schoolapp.domain.SchoolWeek;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.service.ChatMessageService;
import ru.sevastopall.schoolapp.service.ChatService;
import ru.sevastopall.schoolapp.service.MessageService;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/messenger")
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final ChatService chatService;

    private final ChatMessageService chatMessageService;

    @GetMapping("/messages/all")
    public String getMessageList(Model model, HttpSession session) {
        model.addAttribute("messages", messageService.findByReceiver((User) session.getAttribute("user")));
        model.addAttribute("chats", chatService.findByParticipantsContaining((User) session.getAttribute("user")));
        return "/messenger/messages/all";
    }

    @GetMapping("/chats/{id}")
    public String getChat(Model model, @PathVariable long id) {
        List<ChatMessage> messages = chatMessageService.findByChat(chatService.findById(id));
        model.addAttribute("chatMessages", messages);
        return "/messenger/chats/one";
    }
}

