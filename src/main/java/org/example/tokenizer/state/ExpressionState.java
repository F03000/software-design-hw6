package org.example.tokenizer.state;

import org.example.token.*;
import org.example.tokenizer.ExpressionTokenizer;

public class ExpressionState extends AbstractState {
    public ExpressionState(ExpressionTokenizer expressionTokenizer) {
        super(expressionTokenizer);
    }

    @Override
    public void next(Character ch) {
        if (ch == null) {
            expressionTokenizer.setState(new EndState(expressionTokenizer));
            return;
        }
        if (Character.isWhitespace(ch)) {
            expressionTokenizer.setState(this);
            return;
        }

        if (Character.isDigit(ch)) {
            expressionTokenizer.setState(new NumberState(expressionTokenizer, Integer.parseInt(ch.toString())));
        } else if (ch == '(') {
            expressionTokenizer.addToken(new LeftBrace());
        } else if (ch == ')') {
            expressionTokenizer.addToken(new RightBrace());
        } else if (ch == '-') {
            expressionTokenizer.addToken(new Sub());
        } else if (ch == '+') {
            expressionTokenizer.addToken(new Add());
        } else if (ch == '*') {
            expressionTokenizer.addToken(new Mul());
        } else if (ch == '/') {
            expressionTokenizer.addToken(new Div());
        } else {
            expressionTokenizer.setState(new ErrorState(expressionTokenizer));
        }
    }
}
