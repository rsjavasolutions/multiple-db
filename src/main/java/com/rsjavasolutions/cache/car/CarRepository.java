package com.rsjavasolutions.cache.car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Long> {

    Set<CarEntity> findAll();

    Optional<CarEntity> findByUuid(String uuid);

    void deleteByUuid(String uuid);
}
