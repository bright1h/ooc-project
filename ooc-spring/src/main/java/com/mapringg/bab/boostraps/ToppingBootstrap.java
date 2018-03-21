package com.mapringg.bab.boostraps;

import com.mapringg.bab.models.Topping;
import com.mapringg.bab.models.ToppingType;
import com.mapringg.bab.repositories.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author mapring
 */
@Component
@Profile("default")
public class ToppingBootstrap implements CommandLineRunner {

    private final ToppingRepository toppingRepository;

    @Autowired
    public ToppingBootstrap(ToppingRepository toppingRepository) {
        this.toppingRepository = toppingRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initData();
    }

    private void initData() {

        Topping caramel = new Topping(ToppingType.CARAMEL, 10);
        toppingRepository.save(caramel);

        Topping butterscotch = new Topping(ToppingType.BUTTERSCOTCH, 10);
        toppingRepository.save(butterscotch);

        Topping chocolateSyrup = new Topping(ToppingType.CHOCOLATE_SYRUP, 10);
        toppingRepository.save(chocolateSyrup);

        Topping chocolatePowder = new Topping(ToppingType.CHOCOLATE_POWDER, 10);
        toppingRepository.save(chocolatePowder);

        Topping matchaPowder = new Topping(ToppingType.MATCHA_POWDER, 10);
        toppingRepository.save(matchaPowder);
    }
}
