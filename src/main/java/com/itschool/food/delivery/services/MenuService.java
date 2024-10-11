package com.itschool.food.delivery.services;

import com.itschool.food.delivery.models.dtos.MenuDTO;
import java.util.List;

public interface MenuService {

    MenuDTO createMenu(MenuDTO menuDTO);
    MenuDTO getMenuById(Long id);
    MenuDTO updateMenuById(Long id, MenuDTO menuDTO);
    void deleteMenuById(Long id);
    List<MenuDTO> getMenus();
}