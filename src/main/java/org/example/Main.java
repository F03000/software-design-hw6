package org.example;

import org.example.token.Token;
import org.example.tokenizer.ExpressionTokenizer;
import org.example.visitor.CalcVisitor;
import org.example.visitor.ParserVisitor;
import org.example.visitor.PrintVisitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputString = "(23 + 10) * 5 - 3 * (32 + 5) * (10 - 4 * 5) + 8 / 2";

        ExpressionTokenizer expressionTokenizer = new ExpressionTokenizer(inputString);
        List<Token> tokens = expressionTokenizer.tokenize();

        ParserVisitor parserVisitor = new ParserVisitor(tokens);
        List<Token> parsed = parserVisitor.parse();

        PrintVisitor printVisitor = new PrintVisitor(parsed);
        printVisitor.print();

        CalcVisitor calcVisitor = new CalcVisitor(parsed);
        System.out.println(calcVisitor.calculate());
    }
}