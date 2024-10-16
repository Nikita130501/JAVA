package com.example.carmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    public List<CarModel> getModelsByBrand(CarBrand brand) {
        return carModelRepository.findByCarBrand(brand);
    }

    public void saveModel(CarModel model) {
        carModelRepository.save(model);
    }

    public CarModel getModelById(Long id) {
        return carModelRepository.findById(id).orElse(null);
    }

    public void deleteModel(Long id) {
        carModelRepository.deleteById(id);
    }
}

