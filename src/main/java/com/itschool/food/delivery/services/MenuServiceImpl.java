package com.itschool.food.delivery.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.food.delivery.exceptions.MenuCreateException;
import com.itschool.food.delivery.models.dtos.MenuDTO;
import com.itschool.food.delivery.models.dtos.UserDTO;
import com.itschool.food.delivery.models.entities.Menu;
import com.itschool.food.delivery.repositories.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    private final ObjectMapper objectMapper;
    private final MenuRepository menuRepository;

    public MenuServiceImpl(ObjectMapper objectMapper, MenuRepository menuRepository) {
        this.objectMapper = objectMapper;
        this.menuRepository = menuRepository;
    }

    @Override
    public MenuDTO createMenu(MenuDTO menuDTO) {
        Menu MenuEntity = objectMapper.convertValue(MenuDTO, Menu.class);
        Menu menuEntityResponse = menuRepository.save(MenuEntity);
        log.info("Menu with id {} was saved", menuEntityResponse.getId());
        return objectMapper.convertValue(menuEntityResponse, MenuDTO.class);
    }

    @Override
    public MenuDTO getMenuById(Long id) {
        return menuRepository.findById(id)
                .map(menu -> objectMapper.convertValue(menu, MenuDTO.class))
                .orElseThrow(() -> new MenuCreateException("Menu with the ID" + id + "not found"));
    }

    @Override
    public List<MenuDTO> getMenus() {
        List<Menu> menus = MenuRepository.findAll();

        return menus.stream()
                .map(menu -> objectMapper.convertValue(menu, MenuDTO.class))
                .toList();
    }

    @Override
    public MenuDTO updateMenuById(Long id, MenuDTO menuDTO) {
        if (MenuDTO == null) {
            throw new IllegalArgumentException("Menu cannot be null");
        }
        return menuRepository.findById(id).map(existingMenu -> {
            existingMenu.setId(menuDTO.getId() != null ? menuDTO.getId() : existingMenu.getId());
            existingMenu.setName(menuDTO.getName() != null ? menuDTO.getName() : existingMenu.getName());
            existingMenu.setDescription(menuDTO.getDescription() != null ? menuDTO.getDescription() : existingMenu.getDescription());
            existingMenu.setPrice(menuDTO.getPrice() != null ? menuDTO.getPrice() : existingMenu.getPrice());


            Menu updateMenu = menuRepository.save(existingMenu);
            log.info("Received MenuDTO: {}", menuDTO);

            return objectMapper.convertValue(updateMenu, MenuDTO.class);
        }).orElseThrow(() -> new MenuCreateException("Menu with the ID" + id + "not found"));
    }

    @Override
    public void deleteMenuById(Long id) {
        menuRepository.deleteById(id);
    }
}