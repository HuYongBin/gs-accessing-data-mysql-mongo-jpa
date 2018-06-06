package sample.spring.bigben0123.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.spring.bigben0123.mongo.model.Customer;
import sample.spring.bigben0123.mongo.repository.CustomerRepository;


@RestController
@RequestMapping(value="cust",produces="application/json")  
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerRepository repository;
	
	@PostMapping("/")
	public Customer add(@RequestBody Customer Customer) {
		LOGGER.info("Customer add: {}", Customer);
		return repository.insert(Customer);
	}
	
	@GetMapping("/{id}")
	public Optional<Customer> findById(@PathVariable("id") String id) {
		LOGGER.info("Customer find: id={}", id);
		return repository.findById(id);
	}
	
	@GetMapping("/")
	public List<Customer> findAll() {
		LOGGER.info("Customer find");
		return repository.findAll();
	}
/*	
	@GetMapping("/department/{departmentId}")
	public List<Customer> findByDepartment(@PathVariable("departmentId") Long departmentId) {
		LOGGER.info("Customer find: departmentId={}", departmentId);
		return repository.findByDepartment(departmentId);
	}
	
	@GetMapping("/organization/{organizationId}")
	public List<Customer> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Customer find: organizationId={}", organizationId);
		return repository.findByOrganization(organizationId);
	}
*/	
}
