package com.api.expensetracker.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.expensetracker.model.Category;
import com.api.expensetracker.repository.CategoryRepository;

@RestController
@RequestMapping("/expenseAPI")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepo;
	
	public CategoryController(CategoryRepository categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}

	@GetMapping("/allCategories")
	Collection<Category> getAllCategories(){
		return categoryRepo.findAll();
	}
	
	@GetMapping("/category/{id}")
	ResponseEntity<?> getCategory(@PathVariable int id){
		Optional<Category> category = categoryRepo.findById(id);
		return category.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/category")
	ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException{
		Category result = categoryRepo.save(category);
		 return ResponseEntity.created(new URI("/expenseAPI/category" + result.getCategory_id())).body(result);
	}
	
	@PutMapping("/category/{id}")
	ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category){
		Category result = categoryRepo.save(category);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/category/{id}")
	ResponseEntity<?> deleteCategory(@PathVariable int id){
		categoryRepo.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
