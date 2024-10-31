package org.example.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Element {
    public List<Element> elements = new ArrayList<Element>();

    public void addElement(Element element) {
        elements.add(element);
    }

    @Override
    public String draw() {
        StringBuilder result = new StringBuilder();
        for (Element element : elements) {
            result.append(element.draw());
        }
        return result.toString();
    }
}

interface Element {
    String draw();
}

class Text implements Element {
    @Override
    public String draw() {
        return "text";
    }
}

class Image implements Element {
    @Override
    public String draw() {
        return "image";
    }
}
