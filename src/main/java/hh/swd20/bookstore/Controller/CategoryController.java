package hh.swd20.bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.bookstore.Domain.Category;
import hh.swd20.bookstore.Domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository repository;
	
	@RequestMapping(value = "/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("categories", repository.findAll());
		return "categorylist";
	}
	@RequestMapping(value = "/create")
	public String addStudent(Model model) {
		model.addAttribute("category", new Category());
		return "createcategory";
	}
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String save(Category category) {
		repository.save(category);
		return "redirect:categorylist";
	}
	
	
}
