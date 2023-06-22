package com.Ctrl;

import com.Services.PersonasService;
import com.Services.PlazasService;
import com.TO.Plazas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PlazasCtrl {

    @Autowired
    private PlazasService plazasService;
    @Autowired
    private PersonasService personasService;

    /* METODOS HTML */
    
    //INICIO
    @GetMapping("/plazas")
    public String inicio(Model model) {
        iniciar(model);
        return "Plazas";
    }

    private String iniciar(Model model) {
        model.addAttribute("titulo","Plazas");       
        if(model.getAttribute("plaza") == null) {
        Plazas plaza = new Plazas();
        model.addAttribute("plaza", plaza);
        }
        var plazas = plazasService.listarPlazas();
        model.addAttribute("plazas", plazas);
        var personas = personasService.listarPersonas();
        model.addAttribute("personas", personas);
        return "Plazas";
    }

    //GUARDAR
    @PostMapping("/plazas/guardar")
    public String guardar(Plazas plaza){
        plazasService.guardar(plaza);
        return "redirect:/plazas";
    }

    //ELIMINAR
    @GetMapping(value="/plazas/eliminar/{idPlazas}")
    public String eliminar(Plazas plaza){
        plazasService.eliminarPlaza(plaza.getIdPlazas());
        return "redirect:/plazas";
    }

    //EDITAR
    @GetMapping(value="/plazas/editar/{idPlazas}")
    public String editar(Plazas plaza, Model model){
        plaza = plazasService.buscarPlaza(plaza.getIdPlazas());
        model.addAttribute("plaza", plaza);
        iniciar(model);
        return "Plazas";
    }


    /* METODOS POSTMAN */

    //GUARDAR
    @PostMapping("/plazas/registrar")
    public ResponseEntity<Plazas> save(@RequestBody Plazas plaza){
        return new ResponseEntity<>(plazasService.guardar(plaza), HttpStatus.OK);
    }

    //ELIMINAR
    @RequestMapping(value="/plazas/eliminarUsr/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarUsr(@PathVariable int id){
        Plazas usr = plazasService.buscarPlaza(id);
        if(usr !=null){
            plazasService.eliminarPlaza(id);
            return new ResponseEntity<>("Elemento eliminado", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Elemento no encontrado", HttpStatus.OK);
        }
    }

    //LISTAR
    @GetMapping("/plazas/listar")
    public ResponseEntity<List<Plazas>> listarPlazas(){
        return new ResponseEntity<>(plazasService.listarPlazas(), HttpStatus.OK);
    }

}
