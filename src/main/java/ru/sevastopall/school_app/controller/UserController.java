package ru.sevastopall.school_app.controller;


import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.sevastopall.school_app.domain.*;
import ru.sevastopall.school_app.service.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
@ThreadSafe
public class UserController {

    private final SimpleUserService userService;
    private final SimpleRoleService roles;
    private TeacherService teachers;
    private StudentService students;
    private SchoolClassService classes;

    @GetMapping("/register")
    public String getRegistationPage(Model model) {
        model.addAttribute("roles", roles.findAll());
        model.addAttribute("classes", classes.findAll());
        return "users/register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute User user, String[] roleId, String classId) {
        user.setConfirmed(false);
        List<Role> roleSet = new ArrayList<>();
        for (String id : roleId) {
            roleSet.add(roles.findById(Integer.parseInt(id)).get());
        }
        user.setRoles(roleSet);
        var savedUser = userService.create(user);
        if (user.getRoles().get(0).getName().equals("Teacher")) {
            teacherRegister(user);
        } else if (user.getRoles().get(0).getName().equals("Student")) {
            studentRegister(user, classId);
        }
        if (savedUser == null) {
            model.addAttribute("message", "Ошибка регистрации. Логин занят.");
            return "error/404";
        }
        return "redirect:users/login";
    }

    public Optional<Student> studentRegister(User user, String classId) {
        Student student = new Student();
        student.setFirstName(user.getFirstName());
        student.setLastName(user.getLastName());
        student.setUser(user);
        student.setSchoolClass(classes.findById(Integer.parseInt(classId)).get());
        return students.save(student);
    }

    public Optional<Teacher> teacherRegister(User user) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(user.getFirstName());
        teacher.setLastName(user.getLastName());
        teacher.setUser(user);
        return teachers.save(teacher);
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

    @GetMapping("/list")
    public String getTeachers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/list";
    }

    @GetMapping("/{id}")
    public String getOneLesson(Model model, @PathVariable int id) {
        var userOptional = userService.findById(id);
        if (userOptional.isEmpty()) {
            model.addAttribute("message", "Пользователя не найдено");
            return "errors/404";
        }
        User user = userOptional.get();
        model.addAttribute("currentUser", user);
        return "users/one";
    }

    @PostMapping("/update")
    public String confirmUser(Model model, String id) {
        var userOptional = userService.findById(Integer.parseInt(id));
        if (userOptional.isEmpty()) {
            model.addAttribute("message", "Пользователя не найдено");
            return "errors/404";
        }
        User user = userOptional.get();
        user.setConfirmed(true);
        userService.create(user);
        return "users/list";
    }
}


