package com.example.springrest.controller;

import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrest.model.Product;
import com.example.springrest.service.BagService;

@RestController
@RequestMapping("/api")
public class BagController {
	
	@Autowired
	private BagService bagService;
	
	@GetMapping()
	public ResponseEntity<List<Product>> getBagProducts() {
		return new ResponseEntity<List<Product>>(bagService.getProducts(), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody Product product){
		return new ResponseEntity<String>(bagService.updateString(product), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(bagService.addProduct(product), HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Product> getProductWith(@PathVariable("name") String name) {
		return new ResponseEntity<Product>(bagService.getProduct(name), HttpStatus.OK);
	}
	
	@DeleteMapping()
	public ResponseEntity<String> deleteProduct(@RequestParam("name") String name) {
		return new ResponseEntity<String>(bagService.deleteProduct(name), HttpStatus.OK);
	}
}
