package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.Address;
import com.johanna.springjpaecommerce.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneMappingBidirectionalTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveMethod() {

        Order order = new Order();
        order.setOrderTrackingNumber("FTO0001");
        order.setTotalQuantity(23);
        order.setStatus("IN PROGRESS");
        order.setTotalPrice(new BigDecimal(22500));

        Address address = new Address();
        address.setCity("Nairobi");
        address.setStreet("Thika Rd");
        address.setCountry("Kenya");
        address.setState("Nairobi");
        address.setZipCode("00200");

        order.setBillingAddress(address);
        address.setOrder(order);

        addressRepository.save(address);

    }

    @Test
    void updateMethod() {

        Address address = addressRepository.findById(1L).get();
        address.setZipCode("40200");
        address.getOrder().setStatus("DELIVERED");
        addressRepository.save(address);

    }

    @Test
    void fetchMethod() {

        Address address = addressRepository.findById(2L).get();

    }

    @Test
    void deleteMethod() {

        addressRepository.deleteById(1L);

    }

}
