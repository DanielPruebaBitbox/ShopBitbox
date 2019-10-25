package com.example.shop.shopproject.controller;

import com.example.shop.shopproject.model.User;
import com.example.shop.shopproject.repository.UserRepository;
import com.example.shop.shopproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String getLoginForm(HttpServletRequest request) {

        String isLogged = (String) request.getSession().getAttribute("user");
        if (isLogged != null)
            return "redirect:/api/v1/products";
        return "h2";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody  User user,  Model model,
                        HttpServletRequest request) {
/*        Long id = user.getId();
        Optional<User> userSearched = userRepository.findById(id);*/
        User emailUser = userRepository.findByEmail(user.getEmail());
        //userSearched = userRepository.findByUserAndPassword(userSearched.getEmail());
        if (emailUser == null) {
            model.addAttribute("invalidCredentials", true);
            model.addAttribute("messageInvalid", "Usuario o contraseña no válidos");
            model.addAttribute("messageClass", "d-block");
            return "Este return es de prueba no hemos encontrado nada";
        }

        request.getSession().setAttribute("user", emailUser.getFirstName());
        System.out.println("Shit just got real");
        System.out.println("user" + emailUser.getEmail());
        String checkPassword = UserService.hashPassword(user.getPassword());
        if(checkPassword.equals(emailUser.getPassword()) ) return "redirect:/home/" + emailUser.getId();  //DEVOLVER TOKEN COMO SE HACE?
        return "Usuario o contraseña no válidos";
    }

/*    @RequestMapping(value = "/session", method = RequestMethod.POST)
    @ResponseBody
    public String newSession(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
        User checkUser = userRepository.findByUserAndPassword(user.getFirstName(), user.getPassword());
        System.out.println(user.getFirstName());
        System.out.println(user.getPassword());
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getRole());
        if(checkUser == null) return "Error";
        else {
            return "Todo bien";
        }
    }*/
}
