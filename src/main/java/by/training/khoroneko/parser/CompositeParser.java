package by.training.khoroneko.parser;

import by.training.khoroneko.composite.TextComponentType;

public class CompositeParser extends AbstractParser {
    public CompositeParser(TextComponentType type, AbstractParser nextParser) {
        this.componentType = type;
        this.nextParser = nextParser;
    }
}
