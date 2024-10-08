package com.dl.auto_vault.car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
    void deleteByName(String carName);
    Optional<Car> findByName(String name);

}

