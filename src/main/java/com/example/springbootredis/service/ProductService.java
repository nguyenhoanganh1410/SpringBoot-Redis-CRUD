package com.example.springbootredis.service;

import java.util.Map;

import javax.annotation.PostConstruct;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.example.springbootredis.model.Product;

@Service
public class ProductService {
	private final String EMPLOYEE_CACHE = "EMPLOYEE";
	 
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Integer, Product> hashOperations;

    // This annotation makes sure that the method needs to be executed after
    // dependency injection is done to perform any initialization.
    @PostConstruct
    private void intializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }
 // Save operation.
    public void save(final Product p) {
        hashOperations.put(EMPLOYEE_CACHE, p.getId(), p);
    }
 
    // Find by Product id operation.
    public Product findById(final String id) {
        return (Product) hashOperations.get(EMPLOYEE_CACHE, id);
    }
    public Map<Integer, Product> findAll() {
        return hashOperations.entries(EMPLOYEE_CACHE);
    }
 // Delete product by id operation.
    public void delete(Integer id) {
        hashOperations.delete(EMPLOYEE_CACHE, id);
    }
	
}
