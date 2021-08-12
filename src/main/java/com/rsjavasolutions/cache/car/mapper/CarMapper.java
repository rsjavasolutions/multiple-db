package com.rsjavasolutions.cache.car.mapper;

import com.rsjavasolutions.cache.car.CarEntity;
import com.rsjavasolutions.cache.car.request.CarRequest;
import com.rsjavasolutions.cache.car.response.CarResponse;

public class CarMapper {

    public static CarEntity mapToEntity(CarRequest request) {
        return new CarEntity(
                request.getBrand(),
                request.getModel());
    }

    public static CarResponse mapToResponse(CarEntity entity) {
        return new CarResponse(
                entity.getUuid(),
                entity.getId(),
                entity.getBrand(),
                entity.getModel(),
                entity.getCreationDateTime()
        );
    }
}
