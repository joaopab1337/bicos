package br.edu.ifpb.bicos.web;

import br.edu.ifpb.bicos.entity.User;
import br.edu.ifpb.bicos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") User user,
                                      BindingResult result) {

        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(user);
        return "redirect:/registration?success";
    }

}
