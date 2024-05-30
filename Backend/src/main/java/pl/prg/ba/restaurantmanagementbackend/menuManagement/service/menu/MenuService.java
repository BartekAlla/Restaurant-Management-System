package pl.prg.ba.restaurantmanagementbackend.menuManagement.service.menu;

import aj.org.objectweb.asm.commons.Remapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.menu.MenuDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.menu.Menu;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.repository.MenuRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuService implements MenuServiceInterface {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu addMenu(MenuDTO menuDTO) {
        if (menuDTO.getName() == null) {
            throw new NullPointerException("Name cannot be null");
        }
        Menu menu = new Menu(0L, menuDTO.getName());
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll().stream()
                .map(menu -> new Menu(menu.getId(), menu.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found"));
    }

    @Override
    public Menu updateMenu(Long id, MenuDTO menuDTO) {
        Menu menu = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setName(menuDTO.getName());
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
