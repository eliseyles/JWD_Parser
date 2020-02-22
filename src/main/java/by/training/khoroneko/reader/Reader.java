package by.training.khoroneko.reader;

import by.training.khoroneko.exception.ReaderException;

public interface Reader {

    String readAll() throws ReaderException;
}
