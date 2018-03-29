package com.mapringg.bab.controllers;

import com.mapringg.bab.models.Menu;
import com.mapringg.bab.repositories.MenuRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author mapring
 */
public class MenuControllerTest {

    @Mock
    private MenuRepository menuRepository;

    private MenuController menuController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        menuController = new MenuController(menuRepository);
    }

    @Test
    public void get() {

        // given
        Menu menu = new Menu();
        menu.setName("Test");

        when(menuRepository.findByName("Test")).thenReturn(Optional.of(menu));

        // when
        Menu menuW = menuController.get("Test");

        // then
        assertEquals("Test", menuW.getName());
    }

    @Test
    public void findAll() {

        // given
        List<Menu> list = new ArrayList<>();
        Menu menu = new Menu();
        Menu menu1 = new Menu();
        menu.setId(1L);
        menu1.setId(2L);
        list.add(menu);
        list.add(menu1);

        when(menuRepository.findAll()).thenReturn(list);

        // when
        List<Menu> menus = (List<Menu>) menuController.findAll();

        // then
        assertEquals(2, menus.size());
    }
}