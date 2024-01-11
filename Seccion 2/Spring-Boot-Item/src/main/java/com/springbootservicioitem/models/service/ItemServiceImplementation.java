package com.springbootservicioitem.models.service;

import com.springbootservicioitem.models.Item;
import com.springbootservicioitem.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemServiceImplementation implements ItemService {

    @Autowired
    private RestTemplate clienteRest;

    @Override
    public List<Item> findAll() {
        Producto[] productosArray = clienteRest.getForObject("http://localhost:8001/listar", Producto[].class);

        if (productosArray != null) {
            List<Producto> productos = Arrays.asList(productosArray);
            return productos.stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
        return new Item(producto, cantidad);
    }
}
