package com.example.shop.shopproject.controller;

import com.example.shop.shopproject.model.User;
import com.example.shop.shopproject.repository.UserRepository;
import com.example.shop.shopproject.service.AuthUtils;
import com.example.shop.shopproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;


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
    public ResponseEntity<String> login(@RequestBody  User user, Model model,
                                HttpServletRequest request) {
        String responseString = "{\"response\": \"Invalid username or password\"}";

        User emailUser = userRepository.findByEmail(user.getEmail());
        if (emailUser == null) {
            model.addAttribute("invalidCredentials", true);
            model.addAttribute("messageInvalid", "Usuario o contraseña no válidos");
            model.addAttribute("messageClass", "d-block");
        }

        request.getSession().setAttribute("user", emailUser.getFirstName());
        String checkPassword = UserService.hashPassword(user.getPassword());
        if(checkPassword.equals(emailUser.getPassword()) ) {
            String authToken = AuthUtils.createJWT(user.getEmail(), "BitBoxTest", "firstLogin",
                    1000*60*60*24);
            return new ResponseEntity<String>("{\"response\": \"" + authToken + "\"}",
                    new HttpHeaders(), HttpStatus.OK);
        }

        return new ResponseEntity<String>(responseString, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

}
