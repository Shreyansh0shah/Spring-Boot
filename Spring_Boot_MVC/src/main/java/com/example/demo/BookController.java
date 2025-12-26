package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
	
	private final BookRepository bookRepo;

	public BookController(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	@GetMapping("/")
	public String showForm (Model model) {
		model.addAttribute("book", new Book());
		return "add-book";
		
	}
	@PostMapping("/save")
	public String saveBook(@ModelAttribute Book book) {
		bookRepo.save(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books")
	public String viewBooks(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "books";
	}
	@GetMapping("/search")
	public String searchBOOK(@RequestParam int bookId,Model model) {
		Book book =bookRepo.findById(bookId).orElse(null);
		model.addAttribute("books",book==null ? null:java.util.List.of(book));
		return "books";
	}
	

}
