package com.company.controller;

import com.company.entity.User;
import com.company.form.UserDetailForm;
import com.company.service.inter.UserServiceInter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
public class UserDetailController {

    @Autowired
    private UserServiceInter userService;

    @RequestMapping(method = RequestMethod.GET, value = "/userdetail")
    public ModelAndView getUserDetail(@RequestParam("id") int id) {

        ModelAndView mv = new ModelAndView("userdetail");
        mv.addObject("userdetail", getUserDetailForm(id));
        return mv;
    }

    @ModelAttribute
    public UserDetailForm getUserDetailForm(@RequestParam(value = "id") int id) {
        UserDetailForm u = new UserDetailForm();
        try {
            User user = userService.getUserById(id);

            u.setId(user.getId());
            u.setName(user.getName());
            u.setSurname(user.getSurname());
            u.setAddress(user.getAddress());
            u.setPhone(user.getPhone());
            u.setEmail(user.getEmail());
            u.setBirthdate(user.getBirthDate().toString());

            return u;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new UserDetailForm();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/userdetail")
    public ModelAndView saveUserDetail(@ModelAttribute("userdetail") UserDetailForm u) {
        User user = userService.getUserById(u.getId());
        user.setName(u.getName());
        user.setSurname(u.getSurname());
        user.setAddress(u.getAddress());
        user.setPhone((u.getPhone()));
        user.setEmail(u.getEmail());
        user.setBirthDate(Date.valueOf(u.getBirthdate()));
        userService.updateUser(user);

        return new ModelAndView("redirect:/usersm");
    }

}
