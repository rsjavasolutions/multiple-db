package com.rsjavasolutions.cache.car.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarRequest implements Serializable {
    private String brand;
    private String model;
}
