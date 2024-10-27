package com.itschool.food.delivery.services;

import com.itschool.food.delivery.models.dtos.*;

import java.util.List;

public interface MenuService {

    MenuDTO getMenuById(Long id);

    ResponseMenuDTO createMenu(RequestMenuDTO requestMenuDTO);

    List<MenuDTO> getMenus();

    MenuDTO updateMenuById(Long id, MenuDTO menuDTO);

    void deleteMenuById(Long id);
}