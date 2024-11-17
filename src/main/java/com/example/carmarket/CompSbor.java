package com.example.carmarket;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CompSbor {
    
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long motherboardPartId;
    private Long processorPartId;
    private Long ramPartId;
    private Long gpuPartId;
    private Long psuPartId;
    private Long storagePartId;

    // Геттеры и сеттеры
    public Long getMotherboardPartId() {
        return motherboardPartId;
    }

    public void setMotherboardPartId(Long motherboardPartId) {
        this.motherboardPartId = motherboardPartId;
    }

    public Long getProcessorPartId() {
        return processorPartId;
    }

    public void setProcessorPartId(Long processorPartId) {
        this.processorPartId = processorPartId;
    }

    public Long getRamPartId() {
        return ramPartId;
    }

    public void setRamPartId(Long ramPartId) {
        this.ramPartId = ramPartId;
    }

    public Long getGpuPartId() {
        return gpuPartId;
    }

    public void setGpuPartId(Long gpuPartId) {
        this.gpuPartId = gpuPartId;
    }

    public Long getPsuPartId() {
        return psuPartId;
    }

    public void setPsuPartId(Long psuPartId) {
        this.psuPartId = psuPartId;
    }

    public Long getStoragePartId() {
        return storagePartId;
    }

    public void setStoragePartId(Long storagePartId) {
        this.storagePartId = storagePartId;
    }
}

