package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.awt.*;
import java.awt.print.Book;
import java.util.ArrayList;

@Entity
public class User{
    @Id
    private Long id;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
