package org.example.token;

import org.example.visitor.TokenVisitor;

public interface Token {
    void accept(TokenVisitor tokenVisitor);
}
