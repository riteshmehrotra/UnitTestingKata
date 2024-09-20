package org.xperience.domain;

public interface InventoryService {
    ItemStatus reserve(String code, int quantity);
}
