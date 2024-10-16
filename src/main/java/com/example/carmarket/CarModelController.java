package com.example.carmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/brands/{brandId}/models")
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    @Autowired
    private CarBrandService carBrandService;

    // Список моделей для конкретного бренда
    @GetMapping
    public String listModels(@PathVariable("brandId") Long brandId, Model model) {
        CarBrand brand = carBrandService.getBrandById(brandId);
        model.addAttribute("models", carModelService.getModelsByBrand(brand));
        model.addAttribute("brand", brand); // Передаем объект бренда в модель
        return "models"; // Шаблон models.html
    }

    // Форма для создания новой модели
    @GetMapping("/new")
    public String showCreateForm(@PathVariable("brandId") Long brandId, Model model) {
        CarBrand brand = carBrandService.getBrandById(brandId);
        model.addAttribute("model", new CarModel());
        model.addAttribute("brand", brand); // Передаем бренд для отображения названия в форме
        return "create_model"; // Шаблон create_model.html
    }

    // Сохранение новой модели
    @PostMapping("/save")
    public String saveModel(@PathVariable("brandId") Long brandId, @ModelAttribute("model") CarModel model) {
        CarBrand brand = carBrandService.getBrandById(brandId);
        model.setCarBrand(brand); // Устанавливаем бренд для модели
        carModelService.saveModel(model);
        return "redirect:/brands/" + brandId + "/models"; // Перенаправляем на список моделей
    }

    // Форма для редактирования модели
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("brandId") Long brandId, @PathVariable("id") Long id, Model model) {
        CarModel existingModel = carModelService.getModelById(id);
        model.addAttribute("model", existingModel); // Передаем существующую модель
        model.addAttribute("brandId", brandId); // Передаем ID бренда для ссылки
        return "edit_model"; // Шаблон edit_model.html
    }

    // Обновление существующей модели
    @PostMapping("/update/{id}")
    public String updateModel(@PathVariable("brandId") Long brandId, @PathVariable("id") Long id, @ModelAttribute("model") CarModel model) {
        CarModel existingModel = carModelService.getModelById(id);
        if (existingModel != null) {
            existingModel.setModelName(model.getModelName()); // Обновляем имя модели
            carModelService.saveModel(existingModel); // Сохраняем изменения
        }
        return "redirect:/brands/" + brandId + "/models"; // Перенаправляем на список моделей
    }

    // Удаление модели
    @GetMapping("/delete/{id}")
    public String deleteModel(@PathVariable("brandId") Long brandId, @PathVariable("id") Long id) {
        carModelService.deleteModel(id); // Удаляем модель
        return "redirect:/brands/" + brandId + "/models"; // Перенаправляем на список моделей
    }
}

