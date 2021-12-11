package com.example.demo.IpmlDao;

import com.example.demo.DAO.IProductDao;
import com.example.demo.Models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class ImplDaoProduct implements IProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product p) {
        entityManager.persist(p);
        return p;
    }

    @Override
    public List<Product> findAll() {
        Query req=entityManager.createQuery("Select p from products p");
        return req.getResultList();
    }

    @Override
    public Product findById(Integer id) {
        Product p=entityManager.find(Product.class,id);
        return p;
    }

    @Override
    public void remove(Integer id) {
       Product p=entityManager.find(Product.class,id);
       entityManager.remove(p);
    }

    @Override
    public void update(Product p) {
       entityManager.merge(p);
    }

    @Override
    public List<Product> findByCategorie(Integer id_cat) {
        Query req=entityManager.createQuery("select p from products p where p.categorie.id_cat=:x");
        req.setParameter("x", id_cat);
        return req.getResultList();

    }
}
