package com.itschool.food.delivery.services;

import com.itschool.food.delivery.models.dtos.RequestOrderDTO;
import com.itschool.food.delivery.models.dtos.ResponseOrderDTO;
import com.itschool.food.delivery.models.entities.Order;
import java.util.List;

public interface OrderService {

    ResponseOrderDTO createOrder(RequestOrderDTO requestOrderDTO);

    ResponseOrderDTO updateOrder(Long id, Order order);

    List<ResponseOrderDTO> getOrders(String status, String address, String date);
}