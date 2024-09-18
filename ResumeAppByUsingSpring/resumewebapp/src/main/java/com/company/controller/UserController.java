package com.company.controller;

import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.DummyService;
import com.company.service.inter.UserServiceInter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceInter userService;

//    @RequestMapping(method = RequestMethod.GET)
//    public String index(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        String phone = request.getParameter("phone");
//        List<User> list = userService.getUsersByCategory(name, surname, phone);
//        request.setAttribute("list", list);
//
//        User loggedInUser  = userService.getUserById(1);
//        request.setAttribute("loggedInUser", loggedInUser);
//        return "users";
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView index(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "phone", required = false) String phone) {

        List<User> list = userService.getUsersByCategory(name, surname, phone);
        ModelAndView mv = new ModelAndView("users");

        mv.addObject("users", list);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usersm")
    public ModelAndView indexM(
            @Valid
            @ModelAttribute("user") UserForm u,
            BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("users");
        if (bindingResult.hasErrors()) {
            return mv;
        }

        List<User> list = userService.getUsersByCategory(u.getName(), u.getSurname(), u.getPhone());
        mv.addObject("users", list);
        return mv;
    }

    @ModelAttribute("user")
    public UserForm getEmptyUserForm() {
        return new UserForm(null, null, null);
    }

    @RequestMapping(method=RequestMethod.POST, value="/usersm")
    public ModelAndView deleteUser(@RequestParam("id") int id) {
        userService.removeUser(id);

        return new ModelAndView("redirect:/usersm");

    }
}
