package com.example.commons.equity.repositories.output;

import com.example.commons.equity.model.entity.output.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {


}
