package parser;

import composite.TextComponent;
import exception.ParseException;
import util.CalculateStringToInt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser extends AbstractParser {
    private static final String EXPRESSION_REGEX = "(?m)(~|~\\(*|\\(*~|\\()?\\d+(\\.\\d+)?(( *\\)* *)([-+*\\/&\\|^]|<<|>>) *~* *\\(* *~* *\\d+(\\.\\d+)?\\)*)+";

    public ExpressionParser(AbstractParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public TextComponent parse(String source) throws ParseException {
        Pattern pattern = Pattern.compile(EXPRESSION_REGEX);
        Matcher matcher = pattern.matcher(source);
        StringBuffer stringBuffer = new StringBuffer();
        String expressionResult;
        while (matcher.find()) {
            expressionResult = String.valueOf(calculateExpression(matcher.group()));
            matcher.appendReplacement(stringBuffer, expressionResult);
        }
        matcher.appendTail(stringBuffer);
        return nextParser.parse(stringBuffer.toString());
    }

    private int calculateExpression(String expression) {
        return new CalculateStringToInt().calculateByPolishNotation(expression);
    }
}
