package su.problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Akshat on 1/1/2015.
 */
public class TestBookCatalogue {

    @Test
    public void testSearchCategory()
    {
        BookCatalogue bookCatalogue = new BookCatalogue();

        bookCatalogue.addBook("Notes To Myself", "Hugh Parther", Genre.Biography);
        bookCatalogue.addBook("Sachin Tendulkar Biography", "Sachin Tendulkar", Genre.Biography);
        bookCatalogue.addBook("Rasabal Line", "Ashwin Sanghi", Genre.Fiction);
        bookCatalogue.addBook("Immortals Of Meluha", "Amish Tripathi", Genre.Fiction);
        bookCatalogue.addBook("Black Holes", "Stephen Hawkings", Genre.Science);
        bookCatalogue.addBook("Relativity", "Albert Einstein", Genre.Science);

        List<Book> books = bookCatalogue.search(Genre.Biography.name());
        Assert.assertEquals(2, books.size());
        Assert.assertEquals("Notes To Myself", books.get(0).getName());
        Assert.assertEquals("Sachin Tendulkar Biography", books.get(1).getName());

        books = bookCatalogue.search("Notes To Myself");
        Assert.assertEquals(1, books.size());
        Assert.assertEquals("Notes To Myself", books.get(0).getName());

        books = bookCatalogue.search("Ashwin Sanghi");
        Assert.assertEquals(1, books.size());
        Assert.assertEquals("Rasabal Line", books.get(0).getName());


    }
}
