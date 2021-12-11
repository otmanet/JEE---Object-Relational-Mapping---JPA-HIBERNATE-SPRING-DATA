package com.example.demo.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name="categories")
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id_cat;

    @Column(name="type_cat")
    private  String type;

    @OneToMany(mappedBy = "categorie",fetch = FetchType.LAZY)
    private List<Product> listProducts;

    public Categorie (){}

    public Categorie(String type) {
        this.type = type;
    }
    public  Categorie(Integer id_cat){
        this.id_cat=id_cat;
    }
    public Integer getId_cat() {
        return id_cat;
    }

    public void setId_cat(Integer id_cat) {
        this.id_cat = id_cat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
    }
}
