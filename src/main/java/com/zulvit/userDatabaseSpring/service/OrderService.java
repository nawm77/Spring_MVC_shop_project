package com.zulvit.userDatabaseSpring.service;

import com.zulvit.userDatabaseSpring.database.OrderRepository;
import com.zulvit.userDatabaseSpring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final InvoiceService invoiceService;

    @Autowired
    public OrderService(OrderRepository orderRepository, InvoiceService invoiceService) {
        this.orderRepository = orderRepository;
        this.invoiceService = invoiceService;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.getOne(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(Long id) {
        invoiceService.deleteByOrderId(id);
        orderRepository.deleteById(id);
    }

    public void update(Order order) {
        orderRepository.save(order);
    }
}
