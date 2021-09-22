package com.js.dao;

import com.js.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductProvidersDao extends JpaRepository<Product,Integer> {
}
