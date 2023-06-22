package com.Ctrl;

import com.Services.ConfiguracionService;
import com.TO.Configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ConfiguracionCtrl {

    @Autowired
    private ConfiguracionService configuracionService;

    /* METODOS HTML */
    
    //INICIO
    @GetMapping("/configuracion")
    public String inicio(Model model) {
        model.addAttribute("titulo","Configuracion");       
        Configuracion configuracion = configuracionService.buscarConfiguracion(1);
        model.addAttribute("configuracion", configuracion);
        return "Configuracion";
    }

    //GUARDAR
    @PostMapping("/configuracion/guardar")
    public String guardar(Configuracion configuracion){
        configuracionService.guardar(configuracion);
        return "redirect:/configuracion";
    }

}
