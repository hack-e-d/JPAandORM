package org.hacked.entities.keys;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductKey implements Serializable {

    private String code;

    private long number;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    //Creating the equals and hash function

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductKey that = (ProductKey) o;
        return number == that.number && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, number);
    }

    @Override
    public String toString() {
        return "ProductKey{" +
                "code='" + code + '\'' +
                ", number=" + number +
                '}';
    }
}
