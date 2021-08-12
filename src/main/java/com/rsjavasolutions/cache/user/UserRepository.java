package com.rsjavasolutions.cache.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Set<UserEntity> findAll();

    Optional<UserEntity> findByUuid(String uuid);

    void deleteByUuid(String uuid);
}
