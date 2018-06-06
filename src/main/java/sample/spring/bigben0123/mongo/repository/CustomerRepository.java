package sample.spring.bigben0123.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import sample.spring.bigben0123.mongo.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}
