package com.example.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springrest.dao.BagRepository;
import com.example.springrest.model.Product;

@Component
public class BagService {
	
	@Autowired
	private BagRepository bagRepository;
	
	public List<Product> getProducts(){
		return bagRepository.getProducts();
	}
	
	public Product getProduct(String name) {
		return bagRepository.getProduct(name);
	}
	
	public Product addProduct(Product product) {
		return bagRepository.addProduct(product);
	}
	
	public String updateString(Product pro) {
		return bagRepository.updateProductWithQuantity(pro);
	}
	
	public String deleteProduct(String name) {
		return bagRepository.deleteProduct(name);
	}
}
