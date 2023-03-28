package com.example.evaluacionviviana.Controlador;

import com.example.evaluacionviviana.Modelo.Producto;
import com.example.evaluacionviviana.Servicio.servicioProducto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class controladorProducto {
    servicioProducto producto=new servicioProducto();

    @PostMapping("/actualizarPrecio")
    public String actualizarPrecio(@RequestBody Producto product){
        return producto.actualizarPrecio(product);
    }

    @GetMapping("/listarProductos")
    public ArrayList<Producto>listarProducto(){
        return producto.listar();
    }

    @GetMapping("/totalPorProducto")
    public ArrayList<Producto> totalPoProductos(){return producto.totalPorProducto();}


    @GetMapping("/total")
    public double total(){
        return producto.total();
    }

}