package com.itschool.food.delivery.services;

import com.itschool.food.delivery.models.dtos.MenuDTO;
import com.itschool.food.delivery.models.dtos.ResponseMenuDTO;
import java.util.List;

public interface MenuService {

    ResponseMenuDTO createMenu(MenuDTO menuDTO);
    ResponseMenuDTO getMenuById(Long id);
    ResponseMenuDTO updateMenuById(Long id, MenuDTO menuDTO);
    void deleteMenuById(Long id);
    List<MenuDTO> getMenus();
}