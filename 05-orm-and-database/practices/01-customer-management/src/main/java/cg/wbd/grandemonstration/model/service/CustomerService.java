package cg.wbd.grandemonstration.model.service;

import cg.wbd.grandemonstration.model.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findOne(Long id);

    Customer save(Customer customer);

    void add(Customer customer);

    boolean exists(Long id);

    long count();

    void delete(Long id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}
