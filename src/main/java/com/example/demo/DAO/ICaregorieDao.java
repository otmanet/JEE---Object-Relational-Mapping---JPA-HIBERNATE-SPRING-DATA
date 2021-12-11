package com.example.demo.DAO;

import com.example.demo.Models.Categorie;

import java.util.List;

public interface ICaregorieDao {
    public Categorie save(Categorie c);
    public List<Categorie> findAll();
    public Categorie findById(Integer id);
    public void remove(Integer id);
    public void update(Categorie c);

}
