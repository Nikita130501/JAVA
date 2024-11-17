package com.example.carmarket.controller;

import com.example.carmarket.CompSbor;
import com.example.carmarket.ComputerBuildRepository;
import com.example.carmarket.CarPart;
import com.example.carmarket.CarPartRepository; // Импортируем репозиторий комплектующих
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

@Controller
public class ViewComputerBuildsController {

    @Autowired
    private ComputerBuildRepository computerBuildRepository;

    @Autowired
    private CarPartRepository carPartRepository; // Добавляем зависимость для CarPartRepository

    @GetMapping("/view-computer-builds")
    public String viewComputerBuilds(Model model) {
        // Извлекаем все сохранённые сборки
        List<CompSbor> savedBuilds = computerBuildRepository.findAll();

        // Список для хранения сборок с комплектующими
        List<Map<String, String>> buildsWithParts = new ArrayList<>();

        // Проходим по всем сохранённым сборкам
        for (CompSbor build : savedBuilds) {
            Map<String, String> buildDetails = new HashMap<>();

            // Извлекаем комплектующие по ID и добавляем их наименования
            buildDetails.put("Motherboard", getPartNameById(build.getMotherboardPartId()));
            buildDetails.put("Processor", getPartNameById(build.getProcessorPartId()));
            buildDetails.put("RAM", getPartNameById(build.getRamPartId()));
            buildDetails.put("GPU", getPartNameById(build.getGpuPartId()));
            buildDetails.put("PSU", getPartNameById(build.getPsuPartId()));
            buildDetails.put("Storage", getPartNameById(build.getStoragePartId()));

            // Добавляем детали сборки в список
            buildsWithParts.add(buildDetails);
        }

        // Добавляем список сборок с комплектующими на страницу
        model.addAttribute("builds", buildsWithParts);

        // Возвращаем название страницы для отображения сборок
        return "view-computer-builds"; // Страница для отображения сборок
    }

    // Вспомогательный метод для получения наименования комплектующего по ID
    private String getPartNameById(Long partId) {
        // Находим комплектующее по ID в репозитории
        CarPart part = carPartRepository.findById(partId).orElse(null);
        // Если комплектующее найдено, возвращаем его наименование, иначе "Unknown Part"
        return (part != null) ? part.getPartName() : "Unknown Part"; 
    }
}

