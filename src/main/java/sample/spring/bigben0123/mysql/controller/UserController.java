package sample.spring.bigben0123.mysql.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sample.spring.bigben0123.mysql.model.User;
import sample.spring.bigben0123.mysql.repository.UserRepository;


@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserRepository repository;
	
	@PostMapping("/")
	public User add(@RequestBody User User) {
		LOGGER.info("User add: {}", User);
		return repository.save(User);
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable("id") Long id) {
		LOGGER.info("User find: id={}", id);
		return repository.getOne(id);
	}
	
	@GetMapping("/")
	public List<User> findAll() {
		LOGGER.info("User find");
		return repository.findAll();
	}

}
