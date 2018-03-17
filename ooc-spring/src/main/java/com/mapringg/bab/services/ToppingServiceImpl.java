package com.mapringg.bab.services;

import com.mapringg.bab.models.Topping;
import com.mapringg.bab.repositories.ToppingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mapring
 */
@Service
public class ToppingServiceImpl implements ToppingService {

    private ToppingRepository toppingRepository;

    public ToppingServiceImpl(ToppingRepository toppingRepository) {
        this.toppingRepository = toppingRepository;
    }

    @Override
    public List<Topping> getToppings() {
        List<Topping> toppingList = new ArrayList<>();
        toppingRepository.findAll().iterator().forEachRemaining(toppingList::add);
        return toppingList;
    }
}
