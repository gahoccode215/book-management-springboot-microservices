package com.gahoccode.inventory.service;

import com.gahoccode.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity){
        log.info("InventoryService");
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual( skuCode,  quantity);
    }
}
