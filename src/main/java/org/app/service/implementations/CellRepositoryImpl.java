package org.app.service.implementations;

import org.app.entities.Banknote;
import org.app.entities.Cell;
import org.app.reposetories.CellRepository;

import java.util.Map;

public class CellRepositoryImpl implements CellRepository {
    @Override
    public Cell createCell(Banknote banknote, int amount) {
        return new Cell(banknote.getBanknoteDenomination(), banknote, amount);
    }

    @Override
    public Cell getByDenomination(Map<Integer, Cell> cellMap, int denomination) {
        return cellMap.get(denomination);
    }

    @Override
    public Map<Integer, Cell> addBanknoteInCell(Map<Integer, Cell> cellMap, int denomination, int addAmount) {
        System.out.println("Добавление банкнот в ячейки...");
        System.out.println();

        Cell cell = getByDenomination(cellMap, denomination);
        int amount = cell.getCount() + addAmount;

        cellMap.replace(denomination, cell,
                new Cell(denomination, cell.getBanknote(), amount));

        return cellMap;
    }

    @Override
    public Map<Integer, Cell> extendsBanknoteFromCell(Map<Integer, Cell> cellMap, int denomination, int extendAmount) {
        System.out.println("Выдача...");
        System.out.println();

        Cell cell = getByDenomination(cellMap, denomination);
        if (cell.getCount() < extendAmount){
            throw new RuntimeException("Not enough banknotes");
        }
        int amount = cell.getCount() - extendAmount;

        cellMap.replace(denomination, cell,
                new Cell(denomination, cell.getBanknote(), amount));

        return cellMap;
    }

}
