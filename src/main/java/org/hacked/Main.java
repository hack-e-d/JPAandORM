package org.hacked;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.hacked.entities.Employee;
import org.hacked.entities.Passport;
import org.hacked.entities.Person;
import org.hacked.entities.keys.ProductKey;
import org.hacked.entities.Product;
import org.hacked.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf;

        Map<String,String> props= new HashMap<String,String>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto", "create"); // Create mode lets u create the tables based on ORM and JPA specification that is given
        emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), props);



        EntityManager em = emf.createEntityManager();  // represents the context

        try {
            em.getTransaction().begin();

//            Product p = new Product();
//            ProductKey id = new ProductKey();
//            id.setCode("ABC");
//            id.setNumber(101);
//
//            p.setId(id);
//            p.setColor("Blue");
//            Employee employee1 = new Employee();
//            employee1.setName("Sethu");
//            employee1.setAddress("GOOGLE");
//
//            em.persist(employee1);
//            em.persist(p);
//
//            Product productGot = em.find(Product.class, id);
//            System.out.println(productGot.toString());

            Person person = new Person();
            person.setName("Jhon");

            Passport passport = new Passport();
            passport.setNumber("ABC1234567");

            person.setPassport(passport);

            person.setDescription("Some other user");

//            Order of persist doesn't matter as persist only puts the reference in the context as it is not an insert operation
//            em.persist(passport);
            em.persist(person);

            System.out.println(em.find(Person.class, "1").toString());

            TypedQuery<Person> q = em.createQuery("SELECT p FROM person p WHERE p.passport.number = :number", Person.class);
            q.setParameter("number","ABC1234567");

            System.out.println(q.getResultList());
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}