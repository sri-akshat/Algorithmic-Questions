package su.problems;

import su.dataStructure.TrieNode;

import java.util.List;

/**
 * Created by Akshat on 1/1/2015.
 */
public class BookCatalogue {

    private TrieNode<Book> treeByGenre;

//  TODO :  Remove genre and search should work for all genres

    public BookCatalogue() {
        treeByGenre =  new TrieNode<>('#');
    }

    public void addBook(String name, String author, Genre genre)
    {
        treeByGenre.insert(genre.name(), new Book(name, author, genre));
    }

    public List<Book> search(Genre genre)
    {
        return treeByGenre.searchDocuments(genre.name());
    }
}
