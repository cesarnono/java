/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceamce.salika.controller;

import com.ceamce.salika.model.UsuarioVO;
import com.ceamce.salika.service.UserService;
import java.text.SimpleDateFormat;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Cesar Aguirre Vega
 */
@Controller
//@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "user/index", method = RequestMethod.GET)
    public String index(Model model) {
        System.out.println("index action");
        model.addAttribute("usuarios", this.userService.listarUsuario());
        return "/user/index";
    }

    @RequestMapping(value = "user/showSave", method = RequestMethod.GET)
    public String save(Model model) {
        System.out.println("save action get");
        model.addAttribute("usr", new UsuarioVO());
        return "/user/agr";
    }

    @RequestMapping(value = "user/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("usr") @Valid UsuarioVO usuarioVO, BindingResult bindres) {
        System.out.println("save action post");
        if (bindres.hasErrors()) {
            System.out.println("fallo por validacion de formulario");
            return "/user/agr";
        }
        this.userService.saveUser(usuarioVO);
        return "redirect:/user/index";
    }

    @RequestMapping(value = "user/showUpdate", method = RequestMethod.GET)
    public String update(@RequestParam("hiduser") int idUser, Model model) {
        System.out.println("update action get");
        model.addAttribute("usr", this.userService.consultarUsuario(idUser));
        return "/user/mod";
    }

    @RequestMapping(value = "user/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("usr") @Valid UsuarioVO usuarioVO, BindingResult bindres) {
        System.out.println("update action post");
        if (bindres.hasErrors()) {
            System.out.println("fallo por validacion de formulario");
            return "/user/mod";
        }
        this.userService.updateUser(usuarioVO);
        return "redirect:/user/index";
    }

    @RequestMapping(value = "user/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("hiduser") int idUser) {
        this.userService.deleteUser(idUser);
        return "redirect:/user/index";
    }

}
