package com.springbootservicioitem.models.service;

import com.springbootservicioitem.models.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item findById(Long id, Integer cantidad);
}
