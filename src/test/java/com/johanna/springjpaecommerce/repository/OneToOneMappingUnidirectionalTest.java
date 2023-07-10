package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.Address;
import com.johanna.springjpaecommerce.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneMappingUnidirectionalTest {

    @Autowired
    private OrderRepository orderRepository;

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

        orderRepository.save(order);

    }

    @Test
    void getMethod() {

        Order order = orderRepository.findById(2L).get();
        System.out.println(order.toString());

    }

    @Test
    void updateMethod() {

        Order order = orderRepository.findById(1L).get();
        order.setStatus("DELIVERED");
        order.getBillingAddress().setZipCode("40200");
        orderRepository.save(order);

    }

    @Test
    void deleteMethod() {

        orderRepository.deleteById(1L);

    }

}
