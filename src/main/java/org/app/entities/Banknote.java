package org.app.entities;

public enum Banknote {
    TEN(10),
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    THOUSAND(1000);

    private final int banknoteDenomination;

    Banknote(int banknoteDenomination) {
        this.banknoteDenomination = banknoteDenomination;
    }

    public int getBanknoteDenomination() {
        return banknoteDenomination;
    }
}
