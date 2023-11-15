package pl.tnt.library.utils;

import pl.tnt.library.objects.Author;
import pl.tnt.library.objects.Book;

import java.io.*;
import java.util.List;

public class BooksLoader {
    public List<Book> loadAllBooksFromFilePath(String dirPath) {
        throw new RuntimeException("Not implemented!");
    }

    public Book readBookFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        String lineSeparator = "\n";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (true) {
                stringBuilder.append(line);
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                stringBuilder.append(lineSeparator);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(String.format("There was no file with name %s", file.getName()), e);
        } catch (IOException e) {
            throw new RuntimeException(String.format("There was an I/O exception when reading from file '%s'", file.getAbsoluteFile()));
        }
        String[] booksAttributes = stringBuilder.toString().split(lineSeparator);
        Author author = new Author(booksAttributes[0], booksAttributes[1]);
        return new Book(author, booksAttributes[2], Integer.parseInt(booksAttributes[3]));
    }
}
