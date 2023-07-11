package de.aittr.mvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    /*
    GET localhost:8080/users
*/
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
//@RequestMapping(value = "/users",method = RequestMethod.GET)
    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<User>users=service.getaAllUsers();
        model.addAttribute("users",users);
        return "users_view";
    }
}
