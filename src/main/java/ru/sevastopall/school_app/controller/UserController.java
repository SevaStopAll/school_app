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
import ru.sevastopall.school_app.domain.Student;
import ru.sevastopall.school_app.domain.Teacher;
import ru.sevastopall.school_app.domain.User;
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
        student.setName(user.getFirstName());
        student.setUser(user);
        student.setSchoolClass(classes.findById(Integer.parseInt(classId)).get());
        return students.save(student);
    }

    public Optional<Teacher> teacherRegister(User user) {
        Teacher teacher = new Teacher();
        teacher.setName(user.getFirstName());
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
        return "admin/list";
    }

}


