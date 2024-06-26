package org.app.service;

import org.app.entities.Banknote;
import org.app.entities.Cell;
import org.app.reposetories.CellRepository;

import java.util.*;

public class CellService {
    private final CellRepository cellRepository;

    public CellService(CellRepository cellRepository) {
        this.cellRepository = cellRepository;
    }

    public Map<Integer, Cell> createCells(){
        SortedMap<Integer, Cell> cells = new TreeMap<>();
        List<Banknote> banknotes = new ArrayList<>();

        banknotes.addAll(Arrays.stream(Banknote.values()).toList());

        for (Banknote banknote : banknotes){
            cells.put(banknote.getBanknoteDenomination(),
                    cellRepository.createCell(banknote, 2500));
        }
        return cells;
    }

    public List<String> writeCell(Map<Integer, Cell> cellMap){
        List<Integer> denominations = new ArrayList<>();
        List<String> writes = new ArrayList<>();

        denominations.add(10);
        denominations.add(50);
        denominations.add(100);
        denominations.add(500);
        denominations.add(1000);

        int denomination = 0;
        int amount=0;

        for(int i : denominations){
             denomination= cellMap.get(i).getDenomination();
            amount = cellMap.get(i).getCount();
            writes.add("Номинал: " + denomination + " | Количество: " + amount);
        }
        return writes;
    }

    public int getSum(Map<Integer, Cell> cellMap){
        List<Integer> denominations = new ArrayList<>();

        denominations.add(10);
        denominations.add(50);
        denominations.add(100);
        denominations.add(500);
        denominations.add(1000);

        int denomination = 0;
        int amount = 0;
        int sum = 0;

        for(int i : denominations){
            denomination= cellMap.get(i).getDenomination();
            amount = cellMap.get(i).getCount();
            sum = sum + denomination * amount;
        }
        return sum;
    }
}
