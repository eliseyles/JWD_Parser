package reader;

import exception.ReaderException;

import java.io.File;

public interface Reader {

    String readAll() throws ReaderException;
}
