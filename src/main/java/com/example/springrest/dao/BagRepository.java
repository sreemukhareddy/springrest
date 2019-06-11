package com.example.springrest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.springrest.model.Product;

@Component
public class BagRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Set<Product> products;

	@PostConstruct
	public void init() {
		products = new LinkedHashSet<Product>();
		products.add(new Product("apple", "10", "10"));
		products.add(new Product("banana", "5", "20"));
		products.add(new Product("carrot", "20", "5"));
		products.add(new Product("drumsticks", "10", "10"));
		products.add(new Product("egg", "100", "10"));
	}

	public List<Product> getProducts() {
		return (List<Product>) jdbcTemplate.query("SELECT * FROM products", new ProductRowMapper());
	}

	public Product getProduct(String name) {
		String sql = "SELECT * FROM products WHERE name = ?";
		Product product = jdbcTemplate.queryForObject(sql, new Object[] { name }, new ProductRowMapper());
		if(product == null) {
			return null;
		}
		return product;
	}

	public Product addProduct(Product product) {
		String sql ="INSERT INTO products VALUES (?,?,?)";
		int update = jdbcTemplate.update(sql, new Object[] {product.getName(), product.getPrice(), product.getQuantity()});
		if( update != 0) {
			return product;
		}
		return null;
	}

	public String updateProductWithQuantity(Product pro) {
		String sql = "UPDATE products SET quantity = ? WHERE name = ?";
		int update =0;
		update = jdbcTemplate.update(sql, pro.getQuantity(), pro.getName());
		if( update != 0) {
			return "Updated";
		}
		return "gone mad..!";
	}

	public String deleteProduct(String name) {
		String sql = "DELETE FROM products WHERE name = ?";
		int update = 0;
		update = jdbcTemplate.update(sql, name);
		if(update == 0) {
			return "not deleted";
		}
		return "delelted..";
	}

	private class ProductRowMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setName(rs.getString("name"));
			product.setPrice(rs.getString("price"));
			product.setQuantity(rs.getString("quantity"));
			return product;
		}

	}
}
