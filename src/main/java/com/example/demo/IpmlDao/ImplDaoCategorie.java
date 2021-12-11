package com.example.demo.IpmlDao;

import com.example.demo.DAO.ICaregorieDao;
import com.example.demo.Models.Categorie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class ImplDaoCategorie implements ICaregorieDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Categorie save(Categorie c) {
        entityManager.persist(c);
        return c;
    }

    @Override
    public List<Categorie> findAll() {
        Query req=entityManager.createQuery("Select c from categories c");
        return req.getResultList();
    }

    @Override
    public Categorie findById(Integer id) {
        Categorie c=entityManager.find(Categorie.class,id);
        return c;
    }

    @Override
    public void remove(Integer id) {
        Categorie c=entityManager.find(Categorie.class,id);
        entityManager.remove(c);
    }

    @Override
    public void update(Categorie c) {
       entityManager.merge(c);
    }
}
