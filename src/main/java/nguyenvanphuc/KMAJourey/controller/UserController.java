package nguyenvanphuc.KMAJourey.controller;

import lombok.extern.slf4j.Slf4j;
import nguyenvanphuc.KMAJourey.entity.User;
import nguyenvanphuc.KMAJourey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Slf4j
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(){
        return "login";
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, Model model){
        model.addAttribute("username",username);
        return "login";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    //Create User
    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("retypePassword") String retypePassword,
                           Model model) {
        if(userService.checkUser(username)){
            model.addAttribute("error","Tên người dùng đã tồn tại");
            return "register";
        }
        if (!(password.equals(retypePassword))) {
            model.addAttribute("errorPassword", "Mật khẩu không trùng khớp");
            return "register";
        }
        else {
            User user = userService.createUser(username, password);
            model.addAttribute("username", username);
            return "login";
        }
    }

    // Log in
    @PostMapping("/home")
    public String home(@RequestParam("username") String username,
                       @RequestParam("password") String password,
                       Model model){
       boolean check = userService.getUser(username,password);

        if(check){
            return "home";
        }
        else {
            model.addAttribute("error", "Tên người dùng hoặc mật khẩu không đúng");
            return "login";
        }
    }
}
