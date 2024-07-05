package org.app.reposetories;

import org.app.entities.Banknote;
import org.app.entities.Cell;
import org.app.service.CellService;
import org.app.service.implementations.CellRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class CellRepositoryTest {
    private final CellRepository cellRepository = new CellRepositoryImpl();
    private final CellService cellService = new CellService(cellRepository);

    @Test
    void createCell() {
        Cell cell = null;
        assertNull(cell);

        cell = cellRepository.createCell(Banknote.TEN, 10);
        assertNotNull(cell);
    }

    @Test
    void getByDenomination() {
        Map<Integer, Cell> cellMap = cellService.createCells();
        int[] denominations = {10, 50, 100};
        Cell cell = new Cell();

        for (int denomination : denominations) {
            cell = cellRepository.getByDenomination(cellMap, denomination);
            assertEquals(denomination, cell.getDenomination());
        }
    }

    @Test
    void addBanknoteInCell() {
        Map<Integer, Cell> cellMap = cellService.createCells();
        int denomination = 10;
        int add = 20;

        assertEquals(2500, cellMap.get(denomination).getCount());

        cellRepository.addBanknoteInCell(cellMap, denomination, add);

        assertEquals(2500 + add, cellMap.get(denomination).getCount());
    }

    @Test
    void extendsBanknoteFromCell() {
        Map<Integer, Cell> cellMap = cellService.createCells();
        int denomination = 10;
        int extend = 20;

        assertEquals(2500, cellMap.get(denomination).getCount());

        cellRepository.extendsBanknoteFromCell(cellMap, denomination, extend);

        assertEquals(2500 - extend, cellMap.get(denomination).getCount());
    }
}