package com.example.carmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarBrandService {

    @Autowired
    private CarBrandRepository carBrandRepository;

    public List<CarBrand> getAllBrands() {
        return carBrandRepository.findAll();
    }

    public void saveBrand(CarBrand brand) {
        carBrandRepository.save(brand);
    }

    public CarBrand getBrandById(Long id) {
        return carBrandRepository.findById(id).orElse(null);
    }

    public void deleteBrand(Long id) {
        carBrandRepository.deleteById(id);
    }
}

