/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceamce.salika.controller;

import com.ceamce.salika.model.TareaVO;
import com.ceamce.salika.model.UsuarioVO;
import com.ceamce.salika.service.IndexService;
import com.ceamce.salika.util.SqlTimesTampPropertyEditor;
import java.security.Principal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author César Aguirre Vega
 */
@Controller
@SessionAttributes("usuario") 
public class IndexController {

    @Autowired
    private IndexService indexService;
    
    
    @InitBinder
    public final void initBinder(WebDataBinder binder) {
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //dateFormat.setLenient(false);
        binder.registerCustomEditor(Timestamp.class, new SqlTimesTampPropertyEditor("MM/dd/yyyy"));
    }

    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        //System.out.println("Nombre de usuario sesionado: " + principal.getName());
        UsuarioVO usuario = indexService.cargarUsuario(principal.getName());
        model.addAttribute("usuario", usuario);
        //model.addAttribute("tareaN", new TareaVO());
        //rea.addFlashAttribute("usuario", usuario);
       // System.out.println("flash atributes -> "+rea.getFlashAttributes());
        return "index";
    }

    @RequestMapping("/admin/listarTipoNota")
    public String listarTipoNota(Model model) {
        return "lis_tip_not";
    }

    @RequestMapping("/login")
    public String login() {
        return "login/login";
    }

    @RequestMapping(value = "/regtarea", method = RequestMethod.POST)
    public String registrarTarea(@ModelAttribute("tareaN") TareaVO tareaVO, Principal principal) {
        UsuarioVO usuario = indexService.consultarUsuario(principal.getName());
        tareaVO.setUsuario(usuario);
        indexService.registrarTarea(tareaVO);
        return "redirect:/";
    }

    @RequestMapping(value = "/pausarTarea/{idtarea}", method = RequestMethod.POST)
    public String pausarEjecucionTarea(@PathVariable("idtarea") String idtarea, HttpServletRequest request) {
        this.indexService.pausarEjecucionTarea(request, Integer.parseInt(idtarea));
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping(value = "/iniciarTarea/{idtarea}", method = RequestMethod.POST)
    public void iniciarTarea(@PathVariable("idtarea") String idtarea) {
        System.out.println("CONTROLLER IDTAREA: " + idtarea);
        this.indexService.iniciarTarea(Integer.parseInt(idtarea));
    }

    @RequestMapping(value = "/finalizarTarea/{idtarea}", method = RequestMethod.POST)
    public String finalizarTarea(@PathVariable("idtarea") String idtarea, HttpServletRequest request) {
        this.indexService.finalizarTarea(request, Integer.parseInt(idtarea));
        return "redirect:/";
    }

    @RequestMapping(value = "/listarTareaFinalizada", method = RequestMethod.GET)
    public String listarTareasFinalizadas(Model model, Principal principal) {
        TareaVO tareaBusquedaVO = new TareaVO();
        tareaBusquedaVO.setTare_estado("FINALIZADA");
        model.addAttribute("tareaBusqueda", new TareaVO());
        model.addAttribute("listaTareasFinalizadas", this.indexService.listarTareasUsuarioPorEstados(principal.getName(), new String[]{"FINALIZADA"}));
        return "lis_tar_fin";
    }
    
    @RequestMapping("/listarTareaActuales")
    public String listarTareaActuales( Model model){
        model.addAttribute("tareaN", new TareaVO());         
        return "lis_tar_eje";
    }
    
    @RequestMapping("/filtrarTarea")
    public String filtrarTarea(@ModelAttribute("tareaBusqueda") TareaVO tareaBusquedaVO, @ModelAttribute("usuario") UsuarioVO usuario,Model model){
        tareaBusquedaVO.setUsuario(usuario);
        model.addAttribute("listaTareas", this.indexService.listarTareas(tareaBusquedaVO));
        return"lis_tar_fil_ajx";
    }

}
