package org.example.behavioral.visitor;

import lombok.AllArgsConstructor;

// Visitor
public interface DocumentVisitor {
    String visit(Letter letter);
    String visit(Agreement agreement);
}

class DocumentVisitorHTML implements DocumentVisitor {

    @Override
    public String visit(Letter letter) {
        return """
                <h1>%s</h1>
                <p>%s</p>
                <p>%s</p>
                """.formatted(letter.theme, letter.receiver, letter.sender);
    }

    @Override
    public String visit(Agreement agreement) {
        return """
                <h1>%s</h1>
                <i>%s</i>
                """.formatted(agreement.whatAbout, agreement.date);
    }
}


// Element
interface Document {
    String accept(DocumentVisitor visitor);
}

@AllArgsConstructor
class Letter implements Document {

    String receiver;
    String sender;
    String theme;

    @Override
    public String accept(DocumentVisitor visitor) {
        return visitor.visit(this);
    }
}

@AllArgsConstructor
class Agreement implements Document {

    String date;
    String whatAbout;

    @Override
    public String accept(DocumentVisitor visitor) {
        return visitor.visit(this);
    }
}
