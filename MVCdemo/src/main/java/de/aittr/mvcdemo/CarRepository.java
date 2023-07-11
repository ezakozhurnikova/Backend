package de.aittr.mvcdemo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class CarRepository {
    private static List<Car> list = new ArrayList<>(
            List.of(new Car("Audi",123 )
                    , new Car("VW", 676)
                    , new Car("BMW", 8987)
                    , new Car("Volvo", 2046)
                    , new Car("Tesla", 2233)
            ));

    public List<Car> findAll() {
        return list;
    }

    public Optional<Car> findById(Long id) {
        return list.stream().filter(u -> u.getId().equals(id)).findFirst();
    }
}
