package com.Ctrl;

import com.Services.PersonasService;
import com.Services.UsuariosService;
import com.TO.Usuarios;

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
public class UsuariosCtrl {

    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private PersonasService personasService;

    /* METODOS HTML */
    
    //INICIO
    @GetMapping("/usuarios")
    public String inicio(Model model) {
        iniciar(model);
        return "Usuarios";
    }

    private String iniciar(Model model) {
        model.addAttribute("titulo","Usuarios");       
        if(model.getAttribute("usuario") == null) {
        Usuarios usuario = new Usuarios();
        model.addAttribute("usuario", usuario);
        }
        var usuarios = usuariosService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        var personas = personasService.listarPersonas();
        model.addAttribute("personas", personas);
        return "Usuarios";
    }

    //GUARDAR
    @PostMapping("/usuarios/guardar")
    public String guardar(Usuarios usuario){
        usuariosService.guardar(usuario);
        return "redirect:/usuarios";
    }

    //ELIMINAR
    @GetMapping(value="/usuarios/eliminar/{idUsuarios}")
    public String eliminar(Usuarios usuario){
        usuariosService.eliminarUsuario(usuario.getIdUsuarios());
        return "redirect:/usuarios";
    }

    //EDITAR
    @GetMapping(value="/usuarios/editar/{idUsuarios}")
    public String editar(Usuarios usuario, Model model){
        usuario = usuariosService.buscarUsuario(usuario.getIdUsuarios());
        model.addAttribute("usuario", usuario);
        iniciar(model);
        return "Usuarios";
    }


    /* METODOS POSTMAN */

    //GUARDAR
    @PostMapping("/usuarios/registrar")
    public ResponseEntity<Usuarios> save(@RequestBody Usuarios usuario){
        return new ResponseEntity<>(usuariosService.guardar(usuario), HttpStatus.OK);
    }

    //ELIMINAR
    @RequestMapping(value="/usuarios/eliminarUsr/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarUsr(@PathVariable int id){
        Usuarios usr = usuariosService.buscarUsuario(id);
        if(usr !=null){
            usuariosService.eliminarUsuario(id);
            return new ResponseEntity<>("Elemento eliminado", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Elemento no encontrado", HttpStatus.OK);
        }
    }

    //LISTAR
    @GetMapping("/usuarios/listar")
    public ResponseEntity<List<Usuarios>> listarUsuarios(){
        return new ResponseEntity<>(usuariosService.listarUsuarios(), HttpStatus.OK);
    }

}
