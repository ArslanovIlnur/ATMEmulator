package org.app.reposetories;

import org.app.entities.Banknote;
import org.app.entities.Cell;

import java.util.Map;

public interface CellRepository {
    Cell createCell(Banknote banknote, int amount);
    Cell getByDenomination(Map<Integer, Cell> cellMap,int denomination);
    Map<Integer, Cell> addBanknoteInCell(Map<Integer, Cell> cellMap, int denomination, int addAmount);
    Map<Integer, Cell> extendsBanknoteFromCell(Map<Integer, Cell> cellMap, int denomination, int extendAmount);

}
