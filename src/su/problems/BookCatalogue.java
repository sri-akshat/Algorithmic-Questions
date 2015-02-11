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
        bookTrie.insert(genre.name(), new Book(name, author, genre));
        bookTrie.insert(name, new Book(name, author, genre));
        bookTrie.insert(author, new Book(name, author, genre));
    }

    public List<Book> search(String query)
    {
        return bookTrie.searchDocuments(query);
    }
}
