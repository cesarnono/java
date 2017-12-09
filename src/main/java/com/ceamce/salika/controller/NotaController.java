/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceamce.salika.controller;

import com.ceamce.salika.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Cesar Aguirre Vega
 */
@Controller
@RequestMapping("nota/")
@SessionAttributes("idtarea") 
public class NotaController {

    @Autowired
    private NotaService notaService;

    @RequestMapping(method = RequestMethod.GET)
    public String listarNotas(@RequestParam String idtarea, Model model) {
        System.out.println("listarNotas -->");
        model.addAttribute("idtarea", idtarea);
        model.addAttribute("listaNotas", notaService.listarNotas(idtarea));
        return "nota/lis";
    }
    
    @RequestMapping(value = "veridtarea",method = RequestMethod.GET)
    @ResponseBody
    public String mostrarIdtareaActual(Model model,@ModelAttribute("idtarea") String idtarea){
      return "el idtarea es: "+idtarea; // ejemplo para @SessionAttributes
    }
    
    @RequestMapping("actualizar")
    public String actualizarNota(@RequestParam("idNota")String idNota,
            @RequestParam("descripcionNota") String descripcionNota,
             @ModelAttribute ("idtarea") String idtarea){
        this.notaService.actualizarNota(idNota, descripcionNota);
        return "redirect:/nota/";
    }

}
