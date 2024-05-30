package pl.prg.ba.restaurantmanagementbackend.menuManagement.service.menu;

import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.menu.MenuDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.menu.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuServiceInterface {
    public Menu addMenu(MenuDTO menuDTO);

    public List<Menu> getAllMenus();

    public Menu getMenuById(Long id);

    public Menu updateMenu(Long id, MenuDTO menuDTO);

    public void deleteMenu(Long id);
}
