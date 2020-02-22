package by.training.khoroneko.sort.impl;

import by.training.khoroneko.composite.TextComponent;
import by.training.khoroneko.composite.TextComponentType;
import by.training.khoroneko.exception.SortException;
import by.training.khoroneko.sort.Sorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SorterBySentenceCountInParagraph implements Sorter {

    @Override
    public void sort(TextComponent textComponent) throws SortException {
        if (textComponent == null || textComponent.getType() != TextComponentType.TEXT) {
            throw new SortException("Invalid argument");
        }

        List<TextComponent> paragraphs = new ArrayList<>();
        Iterator<TextComponent> paragraphIterator = textComponent.getIterator();
        while (paragraphIterator.hasNext()) {
            TextComponent component = paragraphIterator.next();
            if (component.getType() == TextComponentType.PARAGRAPH) {
                paragraphs.add(component);
            }
        }

        paragraphs.sort(new ParagraphComparator());

        textComponent.clear();

        for (TextComponent paragraph : paragraphs) {
            textComponent.addComponent(paragraph);
        }
    }

    private class ParagraphComparator implements Comparator<TextComponent> {
        @Override
        public int compare(TextComponent component1, TextComponent component2) {
            return component1.getSize() - component2.getSize();
        }
    }
}
