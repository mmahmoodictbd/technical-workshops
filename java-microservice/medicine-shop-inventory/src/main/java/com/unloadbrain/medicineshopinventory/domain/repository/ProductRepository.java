package com.unloadbrain.medicineshopinventory.domain.repository;

import com.unloadbrain.medicineshopinventory.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
