package su.problems;

import su.dataStructure.TrieNode;

import java.util.List;

/**
 * Created by Akshat on 1/1/2015.
 */
public class BookCatalogue {

    private TrieNode<Book> bookTrie;

    public BookCatalogue() {
        bookTrie =  new TrieNode<>('#');
    }

    public void addBook(String name, String author, Genre genre)
    {
        Book book = new Book(name, author, genre);
        bookTrie.insert(genre.name(), book);
        bookTrie.insert(name, book);
        bookTrie.insert(author, book);
    }

    public List<Book> search(String query)
    {
        return bookTrie.searchDocuments(query);
    }
}
