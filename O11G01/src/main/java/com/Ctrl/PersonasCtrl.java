package com.Ctrl;

import com.Services.PersonasService;
import com.TO.Personas;

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
public class PersonasCtrl {

    @Autowired
    private PersonasService personasService;

    /* METODOS HTML */
    
    //INICIO
    @GetMapping("/personas")
    public String inicio(Model model) {
        iniciar(model);
        return "Personas";
    }

    private void iniciar(Model model) {
        model.addAttribute("titulo","Personas");       
        if(model.getAttribute("persona") == null) {
        Personas persona = new Personas();
        model.addAttribute("persona", persona);
        }
        var personas = personasService.listarPersonas();
        model.addAttribute("personas", personas);
    }

    //GUARDAR
    @PostMapping("/personas/guardar")
    public String guardar(Personas persona){
        personasService.guardar(persona);
        return "redirect:/personas";
    }

    //ELIMINAR
    @GetMapping(value="/personas/eliminar/{idPersonas}")
    public String eliminar(Personas persona){
        personasService.eliminarPersona(persona.getIdPersonas());
        return "redirect:/personas";
    }

    //EDITAR
    @GetMapping(value="/personas/editar/{idPersonas}")
    public String editar(Personas persona, Model model){
        persona = personasService.buscarPersona(persona.getIdPersonas());
        model.addAttribute("persona", persona);
        iniciar(model);
        return "Personas";
    }


    /* METODOS POSTMAN */

    //GUARDAR
    @PostMapping("/personas/registrar")
    public ResponseEntity<Personas> save(@RequestBody Personas persona){
        return new ResponseEntity<>(personasService.guardar(persona), HttpStatus.OK);
    }

    //ELIMINAR
    @RequestMapping(value="/personas/eliminarUsr/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarUsr(@PathVariable int id){
        Personas usr = personasService.buscarPersona(id);
        if(usr !=null){
            personasService.eliminarPersona(id);
            return new ResponseEntity<>("Elemento eliminado", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Elemento no encontrado", HttpStatus.OK);
        }
    }

    //LISTAR
    @GetMapping("/personas/listar")
    public ResponseEntity<List<Personas>> listarPersonas(){
        return new ResponseEntity<>(personasService.listarPersonas(), HttpStatus.OK);
    }

}
