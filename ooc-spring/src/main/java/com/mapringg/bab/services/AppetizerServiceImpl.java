package com.mapringg.bab.services;

import com.mapringg.bab.models.Appetizer;
import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class AppetizerServiceImpl implements AppetizerService {

    private MenuRepository menuRepository;

    public AppetizerServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getAppetizers() {
        List<Menu> appetizerList = new ArrayList<>();
        for (Menu menu : menuRepository.findAll()) {
            if (menu.getMenuType() instanceof Appetizer) {
                appetizerList.add(menu);
            }
        }
        return appetizerList;
    }
}
