package com.itschool.food.delivery.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.food.delivery.exceptions.OrderCreateException;
import com.itschool.food.delivery.models.dtos.*;
import com.itschool.food.delivery.models.entities.Order;
import com.itschool.food.delivery.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final ObjectMapper objectMapper;

    private final OrderRepository orderRepository;

    public OrderServiceImpl(ObjectMapper objectMapper, OrderRepository orderRepository) {
        this.objectMapper = objectMapper;
        this.orderRepository = orderRepository;
    }
    @Override
    public ResponseOrderDTO createOrder(RequestOrderDTO requestOrderDTO) {
        Order orderEntity = objectMapper.convertValue(requestOrderDTO, Order.class);
        Order orderEntityResponse = orderRepository.save(orderEntity);
        log.info("Order with id {} was saved", orderEntityResponse.getId());

        return objectMapper.convertValue(orderEntityResponse, ResponseOrderDTO.class);
    }
    @Override
    public List<OrderDTO> getOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(order -> objectMapper.convertValue(order, OrderDTO.class))
                .toList();
    }
    @Override
    public OrderDTO getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(order -> objectMapper.convertValue(order, OrderDTO.class))
                .orElseThrow(() -> new OrderCreateException("Order with the ID" + id + "not found"));
    }
    @Override
    public OrderDTO updateOrderById(Long id, OrderDTO orderDTO) {
        if (orderDTO == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        return orderRepository.findById(id).map(existingOrder -> {
            existingOrder.setUserId(orderDTO.getUserId() != null ? orderDTO.getUserId() : existingOrder.getUserId());
            existingOrder.setTotalPrice(orderDTO.getTotalPrice() != null ? orderDTO.getTotalPrice() : existingOrder.getTotalPrice());
            existingOrder.setOrderStatus(orderDTO.getUserId() != null ? orderDTO.getOrderStatus() : existingOrder.getOrderStatus());
            existingOrder.setOrderDate(orderDTO.getOrderDate() != null ? orderDTO.getOrderDate() : existingOrder.getOrderDate());
            existingOrder.setDeliveryAddress(orderDTO.getDeliveryAddress() != null ? orderDTO.getDeliveryAddress() : existingOrder.getDeliveryAddress());

            Order updateOrder = orderRepository.save(existingOrder);
            log.info("Received OrderDTO: {}", orderDTO);

            return objectMapper.convertValue(updateOrder, OrderDTO.class);
        }).orElseThrow(() -> new OrderCreateException("Order with the ID" + id + "not found"));
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}