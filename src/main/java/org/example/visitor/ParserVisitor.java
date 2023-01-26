package org.example.visitor;

import org.example.token.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParserVisitor implements TokenVisitor {
    Stack<Token> operations;
    List<Token> input;
    List<Token> result;

    public ParserVisitor(List<Token> input) {
        this.input = input;
        this.operations = new Stack<>();
        this.result = new ArrayList<>();
    }

    public List<Token> parse() {
        for (Token token : input) {
            token.accept(this);
        }
        while (!operations.isEmpty()) {
            result.add(operations.pop());
        }
        return result;
    }

    @Override
    public void visit(NumberToken token) {
        result.add(token);
    }

    @Override
    public void visit(Brace token) {
        if (token instanceof LeftBrace) {
            operations.add(token);
        } else {
            while (!operations.isEmpty()) {
                Token operation = operations.pop();
                if (operation instanceof LeftBrace) {
                    return;
                }
                result.add(operation);
            }
        }
    }

    @Override
    public void visit(Operation token) {
        while (!operations.isEmpty()) {
            Token lastOperation = operations.pop();
            if (getOrder(lastOperation) >= getOrder(token)) {
                result.add(lastOperation);
            } else {
                operations.add(lastOperation);
                break;
            }
        }
        operations.add(token);
    }

    private int getOrder(Token token) {
        if (token instanceof Mul || token instanceof Div) {
            return 1;
        } else if (token instanceof Sub || token instanceof Add) {
            return 0;
        } else if (token instanceof LeftBrace) {
            return -1;
        } else {
            throw new IllegalArgumentException("Tokens can not be parsed");
        }
    }
}
