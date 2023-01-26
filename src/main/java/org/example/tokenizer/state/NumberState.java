package org.example.tokenizer.state;

import org.example.token.NumberToken;
import org.example.tokenizer.ExpressionTokenizer;

public class NumberState extends AbstractState {
    private final int accum;

    NumberState(ExpressionTokenizer expressionTokenizer, int accum) {
        super(expressionTokenizer);
        this.accum = accum;
    }

    @Override
    public void next(Character ch) {
        if (ch == null) { // check if string is over
            expressionTokenizer.addToken(new NumberToken(accum));
            expressionTokenizer.setState(new EndState(expressionTokenizer));
            return;
        }

        if (Character.isDigit(ch)) {
            int newAccum = accum * 10 + Integer.parseInt(ch.toString());
            expressionTokenizer.setState(new NumberState(expressionTokenizer, newAccum));
        } else {
            ExpressionState expressionState = new ExpressionState(expressionTokenizer);
            expressionTokenizer.addToken(new NumberToken(accum));
            expressionTokenizer.setState(expressionState);
            expressionState.next(ch);
        }
    }
}
