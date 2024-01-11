package com.app.productos.models.controllers;

import com.app.productos.models.entity.Producto;
import com.app.productos.models.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductoController {

    @Autowired
    private IProductoService iProductoService;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return iProductoService.findAll();
    }

    @GetMapping("/listar/{id}")
    public Producto detalle(@PathVariable Long id) {
        return iProductoService.findById(id);
    }

}
