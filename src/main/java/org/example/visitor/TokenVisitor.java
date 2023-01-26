package org.example.visitor;

import org.example.token.Brace;
import org.example.token.NumberToken;
import org.example.token.Operation;

public interface TokenVisitor {
    void visit(NumberToken token);
    void visit(Brace token);
    void visit(Operation token);
}
