package com.demo.demomarket.persistence;

import com.demo.demomarket.persistence.crud.ProductoCrudRepository;
import com.demo.demomarket.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {

    private ProductoCrudRepository productCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return  (List<Producto>) productCrudRepository.findByIDCategoriaOrderByNombreAswc(idCategoria);
    }

    public List<Producto> queryByCategoria(int idCategoria) {
        return  (List<Producto>) productCrudRepository.queryByIDCategoria(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

}
