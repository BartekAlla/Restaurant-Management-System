package pl.prg.ba.restaurantmanagementbackend.menuManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.prg.ba.restaurantmanagementbackend.menuManagement.entity.menu.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
