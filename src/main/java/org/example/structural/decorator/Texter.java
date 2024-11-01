package org.example.structural.decorator;

interface TextInterface {
    String print();
}

class Texter implements TextInterface {
    private final String text;

    public Texter(String text) {
        this.text = text;
    }

    @Override
    public String print() {
        return text;
    }
}

abstract class TextDecorator implements TextInterface {
    protected TextInterface textInterface;
    public TextDecorator(TextInterface textInterface) {
        this.textInterface = textInterface;
    }
}


class QuoteDecorator extends TextDecorator {
    public QuoteDecorator(TextInterface textInterface) {
        super(textInterface);
    }

    @Override
    public String print() {
        return STR."'\{textInterface.print()}'";
    }
}

class BracketDecorator extends TextDecorator {

    public BracketDecorator(TextInterface textInterface) {
        super(textInterface);
    }

    @Override
    public String print() {
        return STR."{\{textInterface.print()}}";
    }
}