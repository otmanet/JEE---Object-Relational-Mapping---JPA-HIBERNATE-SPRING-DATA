package com.example.demo.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pro;

    @Column(name="desgination")
    private String desgination;

    @Column(name="prix")
    private  double prix;

    @ManyToOne
    @JoinColumn(name="id_cat")
    private  Categorie categorie;

    public Product(){}

    public Product(String desgination, double prix, Categorie categorie) {
        this.desgination = desgination;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Integer getId_pro() {
        return id_pro;
    }

    public void setId_pro(Integer id_pro) {
        this.id_pro = id_pro;
    }

    public String getDesgination() {
        return desgination;
    }

    public void setDesgination(String desgination) {
        this.desgination = desgination;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
