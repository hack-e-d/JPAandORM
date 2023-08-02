package org.hacked;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hacked.Entities.Employee;
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
        emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), props);

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");


        EntityManager em = emf.createEntityManager();  // represents the context

        try {
            em.getTransaction().begin();

//            Product p = new Product();
//            p.setId(2L);
//            p.setName("Chocolate");
//            Employee e = new Employee();
//            e.setId(1);
//            e.setName("vijay");
//            e.setAddress("NASA");

            Employee employee = em.find(Employee.class,1);
            Employee employee1 = new Employee();
            employee1.setName("Sethu");
            employee1.setAddress("GOOGLE");

            em.persist(employee1);

            System.out.println(employee.toString());
//            em.persist(e);  // add this to the context  -> NOT AN INSERT QUERY

//            the data is inserted only into the database during the commit
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}