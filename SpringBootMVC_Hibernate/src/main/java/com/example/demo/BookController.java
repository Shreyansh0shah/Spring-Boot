package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private final BookDAO bookDAO = new BookDAO();

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String viewBooks(Model model) {
        model.addAttribute("books", bookDAO.findAll());
        return "books";
    }

    @GetMapping("/search")
    public String search(@RequestParam int bookId, Model model) {
        Book book = bookDAO.findById(bookId);
        model.addAttribute("books",
                book == null ? List.of() : List.of(book));
        return "books";
    }
}
