package codegym.md.province_management.model.service.customer;


import codegym.md.province_management.model.bean.Customer;
import codegym.md.province_management.model.bean.Province;
import codegym.md.province_management.model.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
