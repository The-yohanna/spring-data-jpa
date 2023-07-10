package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.Address;
import com.johanna.springjpaecommerce.model.Order;
import com.johanna.springjpaecommerce.model.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {

        Order order = new Order();
        order.setOrderTrackingNumber("FTO0001");
        order.setStatus("IN PROGRESS");

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(22L).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItem1.setImageUrl("order-item1.png");
        order.getOrderItems().add(orderItem1);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(23L).get());
        orderItem2.setQuantity(3);
        orderItem2.setPrice(orderItem2.getProduct().getPrice().multiply(new BigDecimal(3)));
        orderItem2.setImageUrl("order-item2.png");
        order.getOrderItems().add(orderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

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
    void fetchMethod() {

        Order order = orderRepository.findById(1L).get();
        System.out.println(order.getStatus());
        System.out.println(order.toString());

        for (OrderItem item : order.getOrderItems()) {
            System.out.println(item.getProduct().getName());
        }

    }

    @Test
    void deleteMethod() {

        orderRepository.deleteById(1L);

    }

}
