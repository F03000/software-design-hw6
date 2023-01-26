package org.example.tokenizer;

import org.example.token.Token;
import org.example.tokenizer.state.AbstractState;
import org.example.tokenizer.state.EndState;
import org.example.tokenizer.state.ExpressionState;

import java.util.ArrayList;
import java.util.List;

public class ExpressionTokenizer {
    private final List<Token> tokens;
    private final String inputString;
    private AbstractState state;

    public ExpressionTokenizer(String inputString) {
        this.inputString = inputString;
        this.tokens = new ArrayList<>();
        this.state = new ExpressionState(this);
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public void setState(AbstractState state) {
        this.state = state;
    }

    public List<Token> tokenize() {
        for (int i = 0; i <= inputString.length(); i++) {
            Character currentChar = i < inputString.length() ? inputString.charAt(i) : null;
            state.next(currentChar);
        }
        if (!(state instanceof EndState)) {
            throw new IllegalStateException("Could not tokenize");
        }
        return tokens;
    }
}
