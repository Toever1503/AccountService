package com.graphql.entityResolver;

import com.entity.Customer;
import com.entity.model.CustomerModel;
import com.service.ICustomerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerResolver implements GraphQLMutationResolver, GraphQLQueryResolver {
    private final ICustomerService customerService;

    public CustomerResolver(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public Customer findCustomerById(Long id) {
        return customerService.findById(id);
    }

    public List<Customer> findAllCustomers(int page, int size) {
        return customerService.findAll(PageRequest.of(page, size)).getContent();
    }

    public Customer createCustomer(CustomerModel customerModel) {
        return customerService.add(customerModel);
    }
}
