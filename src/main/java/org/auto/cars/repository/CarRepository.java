package org.auto.cars.repository;

import org.auto.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT Car FROM Car where Car.prodYear=:prodYear")
    List<Car> findByProdYear(@Param("prodYear") Integer prodYear);

    @Query("select Car from Car where Car.model =: model")
    Car findByModel(@Param("model") String model);
}
