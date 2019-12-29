package deepu.proj.spring5webapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import deepu.proj.spring5webapp.model.Books;
import deepu.proj.spring5webapp.repository.BookRepository;

@Controller
public class BookController {
	private BookRepository repository;

	/**
	 * @param repository
	 */
	public BookController(BookRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(path = "/books")
	public String getBooks(Model model) {

		model.addAttribute("books", repository.findAll());
		return "viewBooks";
	}
}
