package ru.sevastopall.school_app.controller;


import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.school_app.domain.Role;
import ru.sevastopall.school_app.domain.User;
import ru.sevastopall.school_app.service.SimpleRoleService;
import ru.sevastopall.school_app.service.SimpleUserService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
@ThreadSafe
public class UserController {

    private final SimpleUserService userService;
    private final SimpleRoleService roles;

    @GetMapping("/register")
    public String getRegistationPage(Model model) {
        model.addAttribute("roles", roles.findAll());
        return "users/register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute User user, String[] roleId) {
        user.setConfirmed(false);
        List<Role> roleSet = new ArrayList<>();
        for (String id : roleId) {
            roleSet.add(roles.findById(Integer.parseInt(id)).get());
        }
        user.setRoles(roleSet);
        var savedUser = userService.create(user);
        if (savedUser == null) {
            model.addAttribute("message", "Ошибка регистрации. Логин занят.");
            return "error/404";
        }
        return "redirect:users/login";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "users/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model, HttpServletRequest request) {
        var userOptional = userService
                .findUserByLoginAndPassword(user.getLogin(), user.getPassword());
        if (userOptional.isEmpty()) {
            model.addAttribute("error", "Почта или пароль введены неверно");
            return "error/404";
        }
        var session = request.getSession();
        session.setAttribute("user", userOptional.get());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/users/login";
    }
}


