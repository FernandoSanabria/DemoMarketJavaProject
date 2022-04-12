package com.demo.demomarket.persistence;

import com.demo.demomarket.persistence.crud.ProductCrudRepository;
import com.demo.demomarket.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {

    private ProductCrudRepository productCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productCrudRepository.findAll();
    }

}
