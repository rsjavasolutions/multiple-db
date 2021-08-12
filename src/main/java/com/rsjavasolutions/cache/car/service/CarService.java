package com.rsjavasolutions.cache.car.service;

import com.rsjavasolutions.cache.car.CarEntity;
import com.rsjavasolutions.cache.car.CarRepository;
import com.rsjavasolutions.cache.car.exception.CarNotFoundException;
import com.rsjavasolutions.cache.car.exception.UserNotFoundException;
import com.rsjavasolutions.cache.car.mapper.CarMapper;
import com.rsjavasolutions.cache.car.request.CarRequest;
import com.rsjavasolutions.cache.car.response.CarResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

import static com.rsjavasolutions.cache.car.mapper.CarMapper.mapToEntity;
import static com.rsjavasolutions.cache.car.mapper.CarMapper.mapToResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    @Transactional
    public Set<CarResponse> getCars() {
        return carRepository.findAll()
                .stream()
                .map(CarMapper::mapToResponse)
                .collect(Collectors.toSet());
    }

    @Transactional
    public CarResponse getCar(String uuid) {
        CarEntity carEntity = carRepository.findByUuid(uuid).orElseThrow(() -> new UserNotFoundException(uuid));
        return mapToResponse(carEntity);
    }

    @Transactional
    public String saveCar(CarRequest request) {
        log.debug("Save car request with params: {}", request);

        return carRepository.save(mapToEntity(request)).getUuid();
    }

    @Transactional
    public CarResponse updateCar(String uuid, CarRequest request) {
        CarEntity carEntity = carRepository.findByUuid(uuid).orElseThrow(() -> new CarNotFoundException(uuid));

        carEntity.setBrand(request.getBrand());
        carEntity.setModel(request.getModel());

        return mapToResponse(carEntity);
    }

    @Transactional
    public void deleteCar(String uuid) {
        carRepository.deleteByUuid(uuid);
    }
}
