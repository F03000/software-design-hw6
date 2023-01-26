package org.example.visitor;

import org.example.token.Brace;
import org.example.token.NumberToken;
import org.example.token.Operation;
import org.example.token.Token;

import java.util.List;

public class PrintVisitor implements TokenVisitor {
    private final List<Token> tokens;

    public PrintVisitor(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void print() {
        for (Token token : tokens) {
            token.accept(this);
            System.out.print(' ');
        }
        System.out.println();
    }
    @Override
    public void visit(NumberToken token) {
        System.out.print(token);
    }

    @Override
    public void visit(Brace token) {
        throw new IllegalArgumentException("Braces are not allowed into PrintVisitor");
    }

    @Override
    public void visit(Operation token) {
        System.out.print(token);
    }
}
