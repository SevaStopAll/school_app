package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.school_app.service.MarkService;

@Controller
@RequestMapping("dairy")
@AllArgsConstructor
public class DairyController {
    private MarkService marks;
}
