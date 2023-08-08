package org.hacked.entities;

import jakarta.persistence.*;

@Entity(name = "person")
@Table(name = "person", schema = "jpa")
@SecondaryTable(
        name = "person_details",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

//    OneToOne implemented here is one directional as only the person knows about the passport entity whereas the other way around is not present
//    The cascade type allows the passport to be persisted when added to a person and only the person is persisted(only persisting the person is enough)
    @OneToOne(cascade = CascadeType.PERSIST) //Can have multiple types of cascading can be applied
    @JoinColumn(name = "passport")
    private Passport passport;

    @Column(table = "person_details")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passport=" + passport +
                ", description='" + description + '\'' +
                '}';
    }
}
