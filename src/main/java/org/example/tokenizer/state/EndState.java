package org.example.tokenizer.state;

import org.example.tokenizer.ExpressionTokenizer;

public class EndState extends AbstractState {
    public EndState(ExpressionTokenizer expressionTokenizer) {
        super(expressionTokenizer);
    }

    @Override
    public void next(Character ch) {
        expressionTokenizer.setState(this);
    }
}
