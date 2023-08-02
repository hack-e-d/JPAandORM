package org.hacked.Entities;

import jakarta.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
