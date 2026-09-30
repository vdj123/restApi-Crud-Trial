package com.trial.RestApiCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trial.RestApiCrud.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
