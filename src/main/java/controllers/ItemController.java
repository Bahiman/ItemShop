package controllers;
import dao.BookDAO;
import models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private BookDAO bookDAO;


    @GetMapping("/items")
    public String showItems(Model model)
    {
        List<Item> items = bookDAO.findAll();

        model.addAttribute("items",items);

        return "items";
    }

    @GetMapping("/items/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Integer id, Model model)
    {

        boolean bookEsists = bookDAO.findById(id).isPresent();

        if (bookEsists) {
            bookDAO.deleteById(id);
        } else {

        }

        return "redirect:/items";
    }
    @GetMapping("/items/edit/{id}")
    public String editBook(@PathVariable(name = "id") Integer id, Model model)
    {
        boolean bookEsists = bookDAO.findById(id).isPresent();

        Item book = null;

        if (bookEsists) {
            book = bookDAO.findById(id).get();
        } else {

        }

        model.addAttribute("item", book);

        model.addAttribute("header", "Edit book     ");


        return "new-item";
    }
}
