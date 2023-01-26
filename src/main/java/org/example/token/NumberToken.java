package org.example.token;

import org.example.visitor.TokenVisitor;

public class NumberToken implements Token {
    private final int number;

    public NumberToken(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void accept(TokenVisitor tokenVisitor) {
        tokenVisitor.visit(this);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
