package su.problems;

/**
 * Created by Akshat on 1/1/2015.
 */
public class Book {

    private String name;
    private String author;
    private Genre genre;

    public Book(String name, String author, Genre genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }
}
