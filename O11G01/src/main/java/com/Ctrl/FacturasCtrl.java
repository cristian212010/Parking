package com.Ctrl;

import com.Services.FacturasService;
import com.Services.PersonasService;
import com.Services.PlazasService;
import com.TO.Facturas;
import com.TO.Plazas;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FacturasCtrl {

    @Autowired
    private FacturasService facturasService;

    @Autowired
    private PlazasService plazasService;

    @Autowired
    private PersonasService personasService;


    /********** METODOS ENTRADAS ***********/
    
    //INICIO Entradas
    @GetMapping("/entradas")
    public String inicioEntradas(Model model) {
        iniciarEntradas(model);
        return "Entradas";
    }

    private void iniciarEntradas(Model model) {
        model.addAttribute("titulo","Registrar Vehículos");
        if(model.getAttribute("factura") == null) {
        Facturas factura = new Facturas();
        model.addAttribute("factura", factura);
        }
        var facturas = facturasService.listarFacturas();
        model.addAttribute("facturas", facturas);

    }

    @GetMapping("/entradas/listarPlazasCarro")
    public String listarPlazasCarro(Model model){
        var plazas = plazasService.plazasLibresxTipo("carro");
        model.addAttribute("plazas", plazas);
        iniciarEntradas(model);
        return "Entradas";
    }

    @GetMapping("/entradas/listarPlazasMoto")
    public String listarPlazasMoto(Model model){
        var plazas = plazasService.plazasLibresxTipo("moto");
        model.addAttribute("plazas", plazas);
        iniciarEntradas(model);
        return "Entradas";
    }

    //GUARDAR
    @PostMapping("/entradas/guardar")
    public String guardar(Facturas factura){
        factura.setTipoContrato("normal");
        Calendar cal = Calendar.getInstance();
        factura.setFechaEntrada(cal.getTime());
        factura.setIdPersonas(1);
        facturasService.guardar(factura);
        Plazas plaza = plazasService.buscarPlaza(factura.getIdPlazas());
        plaza.setEstado("ocupado");
        plazasService.guardar(plaza);
        return "redirect:/facturas";
    }

    //ELIMINAR
    @GetMapping(value="/entradas/eliminar/{idFactura}")
    public String eliminar(Facturas factura){
        facturasService.eliminarFactura(factura.getIdFactura());
        return "redirect:/entradas";
    }

    //EDITAR
    @GetMapping(value="/entradas/editar/{idFactura}")
    public String editar(Facturas factura, Model model){
        factura = facturasService.buscarFactura(factura.getIdFactura());
        model.addAttribute("factura", factura);
        iniciarEntradas(model);
        return "Entradas";
    }

    /********** METODOS SALIDAS ***********/
    //INICIO Entradas
    @GetMapping("/salidas")
    public String inicioSalidas(Model model) {
        iniciarEntradas(model);
        return "Salidas";
    }

    //VER
    @GetMapping(value="/salidas/ver/{idFactura}")
    public String ver(Facturas factura, Model model){
        factura = facturasService.buscarFactura(factura.getIdFactura());
        model.addAttribute("factura", factura);
        iniciarEntradas(model);
        return "Salidas";
    }

    //DarSALIDA
    @GetMapping(value="/salidas/darSalida/{idFactura}")
    public String darSalida(Facturas factura, Model model){
        factura = facturasService.buscarFactura(factura.getIdFactura());
        Calendar cal = Calendar.getInstance();
        factura.setFechaSalida(cal.getTime());
        factura.setFechaFactura(cal.getTime());
        factura.setValor("6000");
        facturasService.guardar(factura);
        Plazas plaza = plazasService.buscarPlaza(factura.getIdPlazas());
        plaza.setEstado("libre");
        plazasService.guardar(plaza);
        model.addAttribute("factura", factura);
        iniciarEntradas(model);
        return "redirect:/facturas";
    }


    /********** METODOS FACTURAS ***********/

    //INICIO
    @GetMapping("/facturas")
    public String inicio(Model model){
        iniciar(model);
        return "Facturas";
    }

    private void iniciar(Model model) {
        model.addAttribute("titulo", "Facturas");
        if(model.getAttribute("factura") == null) {
            Facturas factura = new Facturas();
            model.addAttribute("factura", factura);  
        }
        var facturas = facturasService.listarFacturas();
        model.addAttribute("facturas", facturas);
        var personas = personasService.listarPersonas();
        model.addAttribute("personas", personas);
    }

}
