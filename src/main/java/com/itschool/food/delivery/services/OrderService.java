package com.itschool.food.delivery.services;

import com.itschool.food.delivery.models.dtos.OrderDTO;
import com.itschool.food.delivery.models.dtos.RequestOrderDTO;
import com.itschool.food.delivery.models.dtos.ResponseOrderDTO;
import java.util.List;

public interface OrderService {

    OrderDTO getOrderById(Long id);

    ResponseOrderDTO createOrder(RequestOrderDTO requestOrderDTO);

    List<OrderDTO> getOrders();

    OrderDTO updateOrderById(Long id, OrderDTO orderDTO);

    void deleteOrderById(Long id);

}