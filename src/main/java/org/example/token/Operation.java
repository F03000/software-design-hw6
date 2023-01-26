package org.example.token;

import org.example.visitor.TokenVisitor;

public abstract class Operation implements Token {
    @Override
    public void accept(TokenVisitor tokenVisitor) {
        tokenVisitor.visit(this);
    }
}

