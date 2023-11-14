package pl.tnt.library;

import pl.tnt.library.objects.Author;
import pl.tnt.library.objects.Book;

import java.util.List;

public class Library {
    private final List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> searchByTitle(String title) {
        throw new RuntimeException("Not implemented!");
    }

    public List<Book> searchByAuthor(String author){
        throw new RuntimeException("Not implemented!");
    }

    public List<Book> searchByAuthorOrTitle(String phrase){
        throw new RuntimeException("Not implemented!");
    }

    public Author findAuthorWithMostBooks(){
        throw new RuntimeException("Not implemented!");
    }
}
