package com.example.demo.DAO;

import com.example.demo.Models.Product;

import java.util.List;

public interface IProductDao {
    public Product save(Product p);
    public List<Product> findAll();
    public Product findById(Integer id);
    public void remove (Integer id);
    public void update(Product p);
    public List<Product> findByCategorie(Integer idCat);
}
