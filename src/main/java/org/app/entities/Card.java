package org.app.entities;

public class Card {
    private int number;
    private int pinCode;
    private float amount;

    public Card() {
    }

    public Card(int number, int pinCode, float amount) {
        this.number = number;
        this.pinCode = pinCode;
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", pinCode=" + pinCode +
                ", amount=" + amount +
                '}';
    }
}
