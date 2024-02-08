package com.example.projeto_tcp;

public enum Symbol {
    A(65), G(71);

    private int asciiValue;

    public int getAsciiValue() {
        return asciiValue;
    }

    Symbol(int asciiValue) {
        this.asciiValue = asciiValue;
    }
}