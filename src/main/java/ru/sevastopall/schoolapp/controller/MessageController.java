package ru.sevastopall.schoolapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sevastopall.schoolapp.domain.*;
import ru.sevastopall.schoolapp.service.ChatMessageService;
import ru.sevastopall.schoolapp.service.ChatService;
import ru.sevastopall.schoolapp.service.MessageService;
import ru.sevastopall.schoolapp.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/messenger")
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final ChatService chatService;
    private final ChatMessageService chatMessageService;
    private final UserService userService;

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

    @PostMapping("/subjects/create")
    public String saveSubject(@ModelAttribute Message message, String[] usersIds) {

        message.setReceiver(userService.findById(Integer.parseInt(usersIds[1])));
        messageService.save(message);
        Set<Teacher> teacherSet = new HashSet<>();
        for (String id : teachersIds) {
            teacherSet.add(teachers.findById(Integer.parseInt(id)).get());
        }
        subject.setTeachers(teacherSet);
        subjects.save(subject);
        return "redirect:/";
    }
}

