package pl.prg.ba.restaurantmanagementbackend.menuManagement.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.dto.menu.MenuDTO;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.menu.Menu;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.service.menu.MenuService;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @PostMapping
    public ResponseEntity<Menu> addMenu(@RequestBody MenuDTO menuDTO) {
        Menu menu = menuService.addMenu(menuDTO);
        return ResponseEntity.ok(menu);
    }
    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        List<Menu> menus = menuService.getAllMenus();
        return ResponseEntity.ok(menus);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long id) {
        Menu menu = menuService.getMenuById(id);
        return ResponseEntity.ok(menu);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @RequestBody MenuDTO menuDTO) {
        Menu updatedMenu = menuService.updateMenu(id, menuDTO);
        return ResponseEntity.ok(updatedMenu);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }
}
