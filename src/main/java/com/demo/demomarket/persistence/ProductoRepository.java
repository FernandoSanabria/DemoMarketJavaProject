package com.demo.demomarket.persistence;

import com.demo.demomarket.persistence.crud.ProductoCrudRepository;
import com.demo.demomarket.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
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

    public  Optional<Producto> getProducto( int idProducto) {
        return  productCrudRepository.findById(idProducto);
    }

    public Producto save( Producto producto) {
        return productCrudRepository.save(producto);
    }

    public void delete(int producto) {
         productCrudRepository.deleteById(producto);
    }

}
