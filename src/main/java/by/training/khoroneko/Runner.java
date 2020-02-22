package by.training.khoroneko;

import by.training.khoroneko.composite.TextComponent;
import by.training.khoroneko.composite.TextComponentType;
import by.training.khoroneko.exception.ParseException;
import by.training.khoroneko.exception.ReaderException;
import org.apache.log4j.Logger;
import by.training.khoroneko.parser.AbstractParser;
import by.training.khoroneko.parser.CompositeParser;
import by.training.khoroneko.parser.ExpressionParser;
import by.training.khoroneko.parser.LeafParser;
import by.training.khoroneko.reader.Reader;
import by.training.khoroneko.reader.impl.TextFileReader;

import java.io.File;
import java.util.Objects;

public class Runner {
    private static final Logger LOGGER = Logger.getLogger(Runner.class);

    public static void main(String[] args) {
        try {
            File sourceTextFile = getFileFromResources("text.txt");
            Reader sourceTextReader = new TextFileReader(sourceTextFile);
            String sourceText = sourceTextReader.readAll();

            AbstractParser symbolParser = new LeafParser();
            AbstractParser wordParser = new CompositeParser(TextComponentType.WORD, symbolParser);
            AbstractParser lexemeParser = new CompositeParser(TextComponentType.LEXEME, wordParser);
            AbstractParser sentenceParser = new CompositeParser(TextComponentType.SENTENCE, lexemeParser);
            AbstractParser paragraphParser = new CompositeParser(TextComponentType.PARAGRAPH, sentenceParser);
            AbstractParser textParser = new CompositeParser(TextComponentType.TEXT, paragraphParser);
            AbstractParser expressionParser = new ExpressionParser(textParser);

            TextComponent textComponent = expressionParser.parse(sourceText);
            LOGGER.trace("---------Source:");
            LOGGER.trace("\n" + sourceText);
            LOGGER.trace("---------After replacing and parsing");
            LOGGER.trace("\n" + textComponent);

//            Sorter sorter = new ParagraphSorterBySentenceAmount();
//            sorter.sort(textComponent);
//            LOGGER.trace("---------After sorting paragraphs by sentence count");
//            LOGGER.trace("\n" + textComponent);

        } catch (ParseException | ReaderException e) {
            LOGGER.error(e);
        }
    }

    private static File getFileFromResources(String fileName) {
        ClassLoader classLoader = Runner.class.getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
    }
}
