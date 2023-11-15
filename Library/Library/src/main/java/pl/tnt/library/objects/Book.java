package pl.tnt.library.objects;

public class Book {
    private final Author author;
    private final String title;
    private final int releaseYear;

    public Book(Author author, String title, int releaseYear) {
        this.author = author;
        this.title = title;
        this.releaseYear = releaseYear;
    }
}
