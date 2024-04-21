package com.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author: qxd
 * @date: 2024/4/21
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        String carJson ="{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        try {
            Car car = objectMapper.readValue(carJson, Car.class);

            System.out.println("car brand = " + car.getBrand());
            System.out.println("car doors = " + car.getDoors());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
