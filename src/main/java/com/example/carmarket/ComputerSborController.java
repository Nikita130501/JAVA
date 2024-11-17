package com.example.carmarket.controller;

import com.example.carmarket.CompSbor;
import com.example.carmarket.ComputerBuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/save-computer-sbor")
public class ComputerSborController {

    private final ComputerBuildRepository computerBuildRepository;

    @Autowired
    public ComputerSborController(ComputerBuildRepository computerBuildRepository) {
        this.computerBuildRepository = computerBuildRepository;
    }

    @PostMapping
    public String saveComputerSbor(
            @RequestParam("partId1") Long motherboardPartId,
            @RequestParam("partId2") Long processorPartId,
            @RequestParam("partId3") Long ramPartId,
            @RequestParam("partId4") Long gpuPartId,
            @RequestParam("partId5") Long psuPartId,
            @RequestParam("partId6") Long storagePartId
    ) {
        // Создаём объект сборки
        CompSbor compSbor = new CompSbor();
        compSbor.setMotherboardPartId(motherboardPartId);
        compSbor.setProcessorPartId(processorPartId);
        compSbor.setRamPartId(ramPartId);
        compSbor.setGpuPartId(gpuPartId);
        compSbor.setPsuPartId(psuPartId);
        compSbor.setStoragePartId(storagePartId);

        // Сохраняем сборку в базе данных
        computerBuildRepository.save(compSbor);

        // Перенаправляем пользователя на страницу с подтверждением или обратно на форму
        return "redirect:/build-computer";
    }
}

