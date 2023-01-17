package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String printUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "User/users";
    }
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "User/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String Edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.get(id));
        return "User/update";
    }

    @PatchMapping("/{id}")
    public String Update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String Delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/users";
    }
}
