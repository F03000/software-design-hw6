package org.example.visitor;

import org.example.token.*;

import java.util.List;
import java.util.Stack;

public class CalcVisitor implements TokenVisitor{
    private final List<Token> tokens;
    private final Stack<NumberToken> numbers;
    public CalcVisitor(List<Token> tokens) {
        this.tokens = tokens;
        this.numbers = new Stack<>();
    }

    public int calculate() {
        for (Token token : tokens) {
            token.accept(this);
        }
        if (numbers.size() != 1) {
            throw new IllegalStateException("Calculator could not calculate result (missing operations)");
        }
        return numbers.pop().getNumber();

    }

    @Override
    public void visit(NumberToken token) {
        numbers.add(token);
    }

    @Override
    public void visit(Brace token) {
        throw new IllegalArgumentException("Braces are not allowed into PrintVisitor");
    }

    @Override
    public void visit(Operation token) {
        if (numbers.size() < 2) {
            throw new IllegalStateException("Calculator could not calculate result (missing numbers)");
        }
        int rightNumber = numbers.pop().getNumber();
        int leftNumber = numbers.pop().getNumber();
        if (token instanceof Add) {
            numbers.add(new NumberToken(leftNumber + rightNumber));
        } else if (token instanceof Sub) {
            numbers.add(new NumberToken(leftNumber - rightNumber));
        } else if (token instanceof Mul) {
            numbers.add(new NumberToken(leftNumber * rightNumber));
        } else if (token instanceof Div) {
            numbers.add(new NumberToken(leftNumber / rightNumber));
        }
    }
}
