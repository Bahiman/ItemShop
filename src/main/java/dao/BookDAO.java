package dao;

import models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookDAO extends JpaRepository<Item,Integer> {

}
