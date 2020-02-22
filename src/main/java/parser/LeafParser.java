package parser;

import composite.Leaf;
import composite.TextComponent;
import composite.TextComponentType;
import exception.ParseException;

public class LeafParser extends AbstractParser {
    private static final int LEAF_LENGTH = 1;
    private static final int CHAR_INDEX = 0;

    public LeafParser() {
        this.componentType = TextComponentType.SYMBOL;
    }

    @Override
    public TextComponent parse(String text) throws ParseException {
        if (text == null) {
            throw new ParseException("Source text isn't exist");
        }
        if (text.length() != LEAF_LENGTH) {
            throw new ParseException("Source text can not be handle.");
        }
        return new Leaf(text.charAt(CHAR_INDEX));
    }
}
