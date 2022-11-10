package com.example.commons.equity.service.output;

import com.example.commons.equity.model.entity.output.Order;
import com.example.commons.equity.model.entity.output.Signal;
import com.example.commons.equity.repositories.output.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final SignalService signalService;

    @Autowired

    public OrderService(OrderRepository orderRepository, SignalService signalService) {
        this.orderRepository = orderRepository;
        this.signalService = signalService;
    }

    public Order createOrder(Signal signal) {
        signalService.save(signal);
        //TODO CREATE REAL ORDER
        Order mockOrder = new Order();
        //FIXME save order orderRepository.save(order)
        return mockOrder;
    }

}
