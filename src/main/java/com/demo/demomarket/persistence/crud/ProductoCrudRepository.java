package com.demo.demomarket.persistence.crud;

import com.demo.demomarket.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {

    // next queries are equivalent one use jpa query methods and the another native sql query consults

    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> queryByIDCategoria(int idCategoria);

    List<Producto> findByIDCategoriaOrderByNombreAswc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
