package br.edu.ifpb.bicos.web;

import br.edu.ifpb.bicos.entity.User;
import br.edu.ifpb.bicos.service.SecurityService;
import br.edu.ifpb.bicos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm) {
        // Validate form here...

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/home";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Usuário ou senha inválidos.");

        if (logout != null)
            model.addAttribute("message", "Logout realizado com sucesso.");

        return "login";
    }

    @GetMapping({"/", "/home"})
    public String welcome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User currentUser = userService.findByUsername(currentPrincipalName);
        if(currentUser == null) return "login";
        model.addAttribute("currentUser", currentUser);
        return "home";
    }

}