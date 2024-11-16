package com.example.carmarket.service;

import com.example.carmarket.CarBrand;
import com.example.carmarket.CarModel;
import com.example.carmarket.CarPart;
import com.example.carmarket.CarBrandRepository;
import com.example.carmarket.CarModelRepository;
import com.example.carmarket.CarPartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerBuildingService {

    @Autowired
    private CarBrandRepository carBrandRepository;

    @Autowired
    private CarModelRepository carModelRepository;

    @Autowired
    private CarPartRepository carPartRepository;

    // Получение всех брендов
    public List<CarBrand> getAllBrands() {
        return carBrandRepository.findAll();
    }

    // Получение моделей по выбранному бренду
    public List<CarModel> getModelsByBrand(Long brandId) {
        CarBrand carBrand = carBrandRepository.findById(brandId).orElse(null);
        if (carBrand != null) {
            return carModelRepository.findByCarBrand(carBrand);
        }
        return null;
    }

    // Получение комплектующих по выбранной модели
    public List<CarPart> getPartsByModel(Long modelId) {
        CarModel carModel = carModelRepository.findById(modelId).orElse(null);
        if (carModel != null) {
            return carPartRepository.findByCarModel(carModel);
        }
        return null;
    }
}

