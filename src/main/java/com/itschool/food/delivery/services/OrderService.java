package com.itschool.food.delivery.services;

import com.itschool.food.delivery.models.dtos.OrderDTO;
import com.itschool.food.delivery.models.dtos.RequestOrderDTO;
import com.itschool.food.delivery.models.dtos.ResponseOrderDTO;
import java.util.List;

public interface OrderService {

    ResponseOrderDTO createOrder(RequestOrderDTO OrderDTO);
    ResponseOrderDTO updateOrderById(Long orderId, RequestOrderDTO orderDTO);
    OrderDTO getOrderById(Long id);
    void deleteOrderById(Long id);
    List<ResponseOrderDTO> getOrders(String address, String status, String date);
}