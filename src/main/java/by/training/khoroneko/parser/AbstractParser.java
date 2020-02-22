package by.training.khoroneko.parser;

import by.training.khoroneko.composite.Composite;
import by.training.khoroneko.composite.TextComponent;
import by.training.khoroneko.composite.TextComponentType;
import by.training.khoroneko.exception.ParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class AbstractParser {
    protected AbstractParser nextParser;
    protected TextComponentType componentType;

    public TextComponent parse(String text) throws ParseException {
        if (text == null) {
            throw new ParseException("Source text isn't exist");
        }
        if (nextParser == null) {
            throw new ParseException("Next by.training.khoroneko.parser wasn't set");
        }
        TextComponent component = new Composite(componentType);
        Pattern pattern = Pattern.compile(componentType.getRegex());
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            component.addComponent(nextParser.parse(matcher.group()));
        }
        if (component.getSize() == 0) {
            component.addComponent(nextParser.parse(text));
        }
        return component;
    }
}
