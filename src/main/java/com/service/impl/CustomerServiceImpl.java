package com.service.impl;

import com.entity.Customer;
import com.entity.model.CustomerModel;
import com.repository.CustomerRepository;
import com.service.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    //    @Autowired -> autowired by setter
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) { // autowired by constructor
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private Customer toEntity(CustomerModel customerModel) {
        if(customerModel == null) return null;
        return Customer.builder()
                .id(customerModel.getId())
                .fullName(customerModel.getFullName())
                .username(customerModel.getUsername())
                .password(this.passwordEncoder.encode(customerModel.getPassword()))
                .email(customerModel.getEmail())
                .isActive(customerModel.getIsActive())
                .phone(customerModel.getPhone())
                .build();

    }

    @Override
    public Customer findById(Long id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Customer add(CustomerModel customerModel) {
        Customer customer = toEntity(customerModel);

        Calendar calendar = Calendar.getInstance();
        customer.setCreatedAt(calendar.getTime());
        customer.setUpdatedAt(calendar.getTime());

        customer.setActivationCode("");
        customer.setStatus(true);
        customer.setIsActive(true);
        customer.setTimeLocked(0l);

        return this.customerRepository.save(customer);
    }

    @Override
    public Customer update(CustomerModel customerModel) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            this.customerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<Customer> search(String keyword, Pageable page) {
        return this.customerRepository.findAllByUsernameLike("%" + keyword + "%", page);
    }

    @Override
    public Page<Customer> findAll(Pageable page) {
        return this.customerRepository.findAll(page);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }
}
