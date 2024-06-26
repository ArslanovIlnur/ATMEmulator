package org.app.entities;

public class Cell {
    private int denomination;
    private Banknote banknote;
    private int count;

    public Cell() {
    }

    public Cell(int denomination, Banknote banknote, int count) {
        this.denomination = denomination;
        this.banknote = banknote;
        this.count = count;
    }

    public int getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    public Banknote getBanknote() {
        return banknote;
    }

    public void setBanknote(Banknote banknote) {
        this.banknote = banknote;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "denomination=" + denomination +
                ", banknote=" + banknote +
                ", count=" + count +
                '}';
    }
}
