package com.itschool.food.delivery.services;

import com.itschool.food.delivery.models.dtos.OrderDTO;
import java.util.List;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO getOrderById(Long id);
    OrderDTO updateOrderById(Long id, OrderDTO orderDTO);
    void deleteOrderById(Long id);
    List<OrderDTO> getOrders();
}
