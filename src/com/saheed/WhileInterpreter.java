package com.saheed;


import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;




@SuppressWarnings({"InfiniteRecursion"})
@BuildParseTree

public class WhileInterpreter  extends BaseParser<Object> {

    public Rule Command(){

        return Sequence( ZeroOrMore(Command()),ZeroOrMore((Spacing()),ZeroOrMore(VariableDeclaratorStatement()),ZeroOrMore(ConditionalExpression()),ZeroOrMore(LoopExpression()),EOI);
    }

    public Rule Spacing(){
        return ZeroOrMore(AnyOf(" \t\r\n\f").label("Whitespace"));

    }

    public Rule VariableDeclaratorStatement(){

        return Sequence( Type(), VariableDeclarators(), SEMI);
    }

    public Rule ConditionalExpression(){

    }

    public Rule LoopExpression(){


    }

    public Rule Type(){
        return Sequence(
                FirstOf("byte", "short", "char", "int", "long", "float", "double", "boolean"),
                TestNot(LetterOrDigit()),
                Spacing()
        );
    }

    public Rule LetterOrDigit(){
        return FirstOf(Sequence('\\', UnicodeEscape()), new JavaLetterOrDigitMatcher());
    }



    @MemoMismatches
    Rule Keyword() {
        return Sequence(
                FirstOf("assert", "break", "case", "catch", "class", "const", "continue", "default", "do", "else",
                        "enum", "extends", "finally", "final", "for", "goto", "if", "implements", "import", "interface",
                        "instanceof", "new", "package", "return", "static", "super", "switch", "synchronized", "this",
                        "throws", "throw", "try", "void", "while"),
                TestNot(LetterOrDigit())
        );
    }


    public final Rule IF = Keyword("if");
    public final Rule THEN = Keyword("then");
    public final Rule ELSE = Keyword("else");
    public final Rule WHILE = Keyword("while");
    public final Rule DO = Keyword("do");
    final Rule SEMI = Terminal(";");















    public static void main(String[] args) {
	// write your code here
    }
}
