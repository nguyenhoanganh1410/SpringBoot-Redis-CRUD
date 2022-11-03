package com.example.springbootredis.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootredis.model.Product;
import com.example.springbootredis.service.ProductService;
@RestController
@RequestMapping("/v1/api/product")
public class Controller {
	private static final Logger LOG = LoggerFactory.getLogger(Controller.class);
	 
    @Autowired
    ProductService service;

    @PostMapping
    public String save(@RequestBody final Product p) {
        LOG.info("Saving the new employee to the redis.");
        service.save(p);
        return "Successfully added. Employee with id= " + p.getId();
    }

    @GetMapping("/getall")
    public Map<Integer, Product> findAll() {
        LOG.info("Fetching all employees from the redis.");
        final Map<Integer, Product> employeeMap = service.findAll();
        // Todo - If developers like they can sort the map (optional).
        return employeeMap;
    }
    
 
    @DeleteMapping("/delete/{id}")
    public Map<Integer, Product> delete(@PathVariable("id") final Integer id) {
        LOG.info("Deleting employee with id= " + id);
        // Deleting the employee.
        service.delete(id);
        // Returning the all employees (post the deleted one).
        return findAll();
    }
    
    
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
