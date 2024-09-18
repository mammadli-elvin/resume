package com.company.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import com.company.form.LoginForm;
import com.company.service.inter.UserServiceInter;
import jakarta.servlet.http.HttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController extends HttpServlet {
    private final BCrypt.Verifyer verifyer = BCrypt.verifyer();

    @Autowired
    UserServiceInter userService;

    @RequestMapping(method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String login(HttpServletRequest request,
//                        @RequestParam(value = "email") String email,
//                        @RequestParam(value = "password") String password) {
//        try {
//            User user = userService.findByEmail(email);
//            if (user == null) {
//                throw new IllegalArgumentException("User doesn't exist!!!");
//            }
//            BCrypt.Result rs = verifyer.verify(password.toCharArray(), user.getPassword().toCharArray());
//            if (!rs.verified) {
//                throw new IllegalArgumentException("Password is incorrect!!!");
//            }
//            return "users";
//        } catch (Exception ex) {
//            request.getSession().setAttribute("msg", ex);
//            return "error";
//        }
//    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
        //This part is handled by Spring Security
//        try {
//            User user = userService.findByEmail(loginForm.getUsername());
//            if (user == null) {
//                throw new IllegalArgumentException("User doesn't exist!!!");
//            }
//            BCrypt.Result rs = verifyer.verify(loginForm.getPassword().toCharArray(), user.getPassword().toCharArray());
//            if (!rs.verified) {
//                throw new IllegalArgumentException("Password is incorrect!!!");
//            }
//            return "redirect:/usersm";
//        } catch (Exception ex) {
//            model.addAttribute("error", ex.getMessage());
//            return "login";
//        }
        return null;
    }

    @ModelAttribute
    LoginForm getEmptyLoginForm() {
        return new LoginForm();
    }
}