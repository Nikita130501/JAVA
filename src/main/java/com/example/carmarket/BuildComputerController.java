package com.example.carmarket.controller;

import com.example.carmarket.CarBrand;
import com.example.carmarket.CarModel;
import com.example.carmarket.CarPart;
import com.example.carmarket.service.ComputerBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BuildComputerController {

    @Autowired
    private ComputerBuildingService computerBuildingService;

    @GetMapping("/build-computer")
    public String showBuildComputerForm(Model model) {
        List<CarBrand> brands = computerBuildingService.getAllBrands();
        model.addAttribute("brands", brands);
        return "build-computer";
    }

    @PostMapping("/build-computer")
    public String buildComputer(@RequestParam("brand") Long brandId,
                                 @RequestParam("modelId") Long modelId,
                                 @RequestParam("partId") Long partId,
                                 Model model) {
        // Получаем выбранные объекты
        CarBrand selectedBrand = computerBuildingService.getAllBrands().stream()
                .filter(brand -> brand.getId().equals(brandId))
                .findFirst().orElse(null);

        CarModel selectedModel = computerBuildingService.getModelsByBrand(brandId).stream()
                .filter(modelItem -> modelItem.getId().equals(modelId))
                .findFirst().orElse(null);

        CarPart selectedPart = computerBuildingService.getPartsByModel(modelId).stream()
                .filter(part -> part.getId().equals(partId))
                .findFirst().orElse(null);

        // Добавляем их в модель для отображения
        model.addAttribute("selectedBrand", selectedBrand);
        model.addAttribute("selectedModel", selectedModel);
        model.addAttribute("selectedPart", selectedPart);

        return "build-computer";
    }

    @PostMapping("/get-models")
    public String getModels(@RequestParam("brandId") Long brandId, Model model) {
        List<CarModel> models = computerBuildingService.getModelsByBrand(brandId);
        model.addAttribute("models", models);
        return "build-computer :: modelList"; // Обновляем только список моделей
    }

    @PostMapping("/get-parts")
    public String getParts(@RequestParam("modelId") Long modelId, Model model) {
        List<CarPart> parts = computerBuildingService.getPartsByModel(modelId);
        model.addAttribute("parts", parts);
        return "build-computer :: partList"; // Обновляем только список комплектующих
    }
}

