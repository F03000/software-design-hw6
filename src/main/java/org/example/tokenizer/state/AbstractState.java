package org.example.tokenizer.state;

import org.example.tokenizer.ExpressionTokenizer;

public abstract class AbstractState {
    protected ExpressionTokenizer expressionTokenizer;

    public AbstractState(ExpressionTokenizer expressionTokenizer) {
        this.expressionTokenizer = expressionTokenizer;
    }

    public abstract void next(Character ch);
}
