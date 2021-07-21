package com.codegym.cms.model.repository;
import com.codegym.cms.model.bean.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}
