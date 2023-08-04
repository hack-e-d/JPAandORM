package org.hacked.entities;

import jakarta.persistence.*;
import org.hacked.entities.keys.ProductKey;

//Composed Primary Key
@Entity(name = "product")
@Table(schema = "jpa")
//not needed when using embedded Id class
//@IdClass(ProductKey.class)
public class Product {

    @EmbeddedId
    private ProductKey id;

    private String color;

    public ProductKey getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public void setId(ProductKey id) {
        this.id = id;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", color='" + color + '\'' +
                '}';
    }
}
