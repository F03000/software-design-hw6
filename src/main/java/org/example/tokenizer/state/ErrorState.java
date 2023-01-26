package org.example.tokenizer.state;

import org.example.tokenizer.ExpressionTokenizer;

public class ErrorState extends AbstractState {
    public ErrorState(ExpressionTokenizer expressionTokenizer) {
        super(expressionTokenizer);
    }

    @Override
    public void next(Character ch) {
        expressionTokenizer.setState(this);
    }
}
