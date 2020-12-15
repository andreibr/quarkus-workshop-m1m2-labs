package org.acme.people.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Person extends PanacheEntity {
    public String name;
    public LocalDate birth;

    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    public EyeColor eyes;

    public static List<Person> findByColor(EyeColor color) {
        return list("eyes", color);
    }

    public static List<Person> getBeforeYear(int year) {
        return Person.<Person>streamAll()
        .filter(p -> p.birth.getYear() <= year)
        .collect(Collectors.toList());
    }

}