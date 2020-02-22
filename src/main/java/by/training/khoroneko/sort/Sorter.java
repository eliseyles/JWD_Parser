package by.training.khoroneko.sort;

import by.training.khoroneko.composite.TextComponent;
import by.training.khoroneko.exception.SortException;

public interface Sorter {
    void sort(TextComponent textComponent) throws SortException;
}
