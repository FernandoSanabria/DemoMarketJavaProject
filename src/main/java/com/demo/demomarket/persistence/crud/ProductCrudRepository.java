package com.demo.demomarket.persistence.crud;

import com.demo.demomarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Producto,Integer> {



}
