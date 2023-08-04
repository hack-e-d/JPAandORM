package org.hacked;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hacked.Entities.Employee;
import org.hacked.Entities.Keys.ProductKey;
import org.hacked.Entities.Product;
import org.hacked.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf;

        Map<String,String> props= new HashMap<String,String>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto", "none"); // Create mode lets u create the tables based on ORM and JPA specification that is given
        emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), props);



        EntityManager em = emf.createEntityManager();  // represents the context

        try {
            em.getTransaction().begin();

            Product p = new Product();
//            p.setCode("ABC");
//            p.setNumber(123);
            ProductKey id = new ProductKey();
            id.setCode("ABC");
            id.setNumber(101);

            p.setId(id);
            p.setColor("Blue");
            Employee employee1 = new Employee();
            employee1.setName("Sethu");
            employee1.setAddress("GOOGLE");

            em.persist(employee1);
            em.persist(p);

            Product productGot = em.find(Product.class, id);
            System.out.println(productGot.toString());

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}