package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String getAllusers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/id")
    public String getUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/id/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/edit";
    }

    @PostMapping("/id")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/id/delete")
    public String delete(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
