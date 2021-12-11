package com.example.demo;

import com.example.demo.DAO.ICaregorieDao;
import com.example.demo.DAO.IProductDao;
import com.example.demo.Models.Categorie;
import com.example.demo.Models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx=SpringApplication.run(DemoApplication.class, args);
        ICaregorieDao iCaregorieDao=ctx.getBean(ICaregorieDao.class);
        IProductDao iProductDao=ctx.getBean(IProductDao.class);
        System.out.println("*************************SAVE CATEGORIES**************************");
        iCaregorieDao.save(new Categorie("Laptop"));
        iCaregorieDao.save(new Categorie("Mouse"));
        iCaregorieDao.save(new Categorie("Keyboard"));
        System.out.println("****************************SAVE PRODUCTS*************************");
        iProductDao.save(new Product("Ord AX 453", 870,new Categorie(1)));
        iProductDao.save(new Product("Ord TA 6753", 1230,new Categorie(2)));
        iProductDao.save(new Product("Imp HP 153", 340,new Categorie(3)));
        System.out.println("****************************LIST CATEGORIE*************************");
        for(Categorie  c: iCaregorieDao.findAll()){
            System.out.println("  | ID_CAT : "+c.getId_cat()+"  | TYPE_CAT : "+c.getType());
        }
        System.out.println("****************************LIST PRODUCT*************************");
        for(Product p: iProductDao.findAll()){
            System.out.println(" | ID_PRO : "+p.getId_pro()+" | DESGINATION : "+p.getDesgination()+" | PRIX : "+p.getPrix()+" | TYPE_CAT :"+p.getCategorie().getType());
        }
        System.out.println("****************************FIND CATEGORIE BY ID*************************");
        Scanner sc=new Scanner(System.in);
        System.out.println(" ID_CATEGORIE DO YOU WANT FIND :");
        int id=sc.nextInt();
        Categorie c=iCaregorieDao.findById(id);
        System.out.println("TYPE_CATEGORIE :"+c.getType());
        System.out.println("****************************FIND PRODUCT BY TYPE CATEGORIE*************************");
        List<Product> pp=iProductDao.findByCategorie(1);
        pp.forEach(p->System.out.println(p.getDesgination()));
//        c.getListProducts().forEach(p->System.out.println(p.getDesgination()));

    }

}
