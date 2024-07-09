package org.app.service;

import org.app.entities.Cell;
import org.app.reposetories.CellRepository;
import org.app.service.implementations.CellRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class CellServiceTest {
    private final CellRepository cellRepository = new CellRepositoryImpl();
    private final CellService cellService = new CellService(cellRepository);
    private Map<Integer, Cell> cellMap = new TreeMap<>();

    @Test
    void createCells() {
        assertEquals(0, cellMap.size());
        cellMap = cellService.createCells();
        assertNotEquals(0, cellMap.size());
    }

    @Test
    void getSum() {
        cellMap = cellService.createCells();
        assertEquals(4150000, cellService.getSum(cellMap));
    }
}