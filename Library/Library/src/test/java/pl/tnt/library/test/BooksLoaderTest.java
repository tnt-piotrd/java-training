package pl.tnt.library.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.tnt.library.objects.Author;
import pl.tnt.library.objects.Book;
import pl.tnt.library.utils.BooksLoader;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BooksLoaderTest {
    private static final String BOOKS_FILE_PATH = "src/test/resources/books";
    BooksLoader booksLoader;

    @BeforeMethod
    public void setup(){
        booksLoader = new BooksLoader();
    }

    @Test
    public void shouldRead6Books(){
        int actualSize = booksLoader.loadAllBooksFromFilePath(BOOKS_FILE_PATH).size();
        assertEquals(actualSize, 6);
    }

    @Test
    public void shouldReadHobbit(){
        Book hobbit = new Book(new Author("John", "Tolkien"), "The Hobbit, or There and Back Again", 1937);
        List<Book> booksLoaded = booksLoader.loadAllBooksFromFilePath(BOOKS_FILE_PATH);
        assertTrue(booksLoaded.contains(hobbit), "Hobbit not found! Instead following books were found: "+booksLoaded);
    }
}
