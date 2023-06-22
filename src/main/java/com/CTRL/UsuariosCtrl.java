package com.CTRL;

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

import com.Services.PersonasService;
import com.Services.UsuariosService;
import com.TO.Usuarios;

@Controller
public class UsuariosCtrl {
  @Autowired
  // private UsuariosDAO usuariosDao; //variable global
  private UsuariosService usuariosService;
  @Autowired
  private PersonasService personasService;
    
  @GetMapping("/usuarios")
  public String inicio(Model model) {
    // objeto de tipo usuarios
    Usuarios usuario = new Usuarios();
    model.addAttribute("usuario", usuario);
    // modelo usuarios
    model.addAttribute("Titulo", "Usuarios");
    var usuarios = usuariosService.listarUsuarios();
    model.addAttribute("usuarios", usuarios);
    /// modelo persona
    var personas = personasService.listarPersonas();
    model.addAttribute("personas", personas);
    return "Usuarios";

  }

  @GetMapping("/usuarios/listar")
  public ResponseEntity<List<Usuarios>> listarUsuarios() {
    return new ResponseEntity<>(usuariosService.listarUsuarios(), HttpStatus.OK);
  }

  @PostMapping("/usuarios/guardar")
  public String guardar(Usuarios usuario) {
    usuariosService.guardar(usuario);
    return "redirect:/usuarios";
  }
   /*METODOS POSMAT */
  @PostMapping("/usuarios/guardarU")
  public ResponseEntity<Usuarios> guadarU(@RequestBody Usuarios usuario) {
    return new ResponseEntity<>(usuariosService.guardar(usuario), HttpStatus.OK);
  }

  @PostMapping("/usuarios/eliminar")
  public void eliminar(@RequestBody Usuarios usuario) {
    usuariosService.eliminar(usuario);
  }

  @RequestMapping(value = "/usuarios/eliminarUsr/{idUsuario}", method = RequestMethod.DELETE)
  public ResponseEntity<String> eliminarUsur(@PathVariable int idUsuario) {
    Usuarios usrio=usuariosService.buscarUsuario(idUsuario);  
   
    usuariosService.eliminarUsuario(idUsuario);

  return null;
    


  }

}
