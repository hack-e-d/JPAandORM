package org.hacked.Entities;

import jakarta.persistence.*;
import org.hacked.Entities.Generators.UUIDGenerator;
import org.hibernate.annotations.GenericGenerator;

/*
* The entity annotation is the name of the context that is used in the ORM
* and not the database the value in the table annotation points to the name
* of the table in the database, and it is generally not needed when table name
* and entity name are the same with case ignored
 */
@Entity(name = "employee")
@Table(schema = "jpa")
public class Employee {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUIDGenerator", type = UUIDGenerator.class)
    @GeneratedValue(generator = "UUIDGenerator")
    private String id;

    private String name;

    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
