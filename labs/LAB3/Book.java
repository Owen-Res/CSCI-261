/**
 * This class represents a very basic book. It models information
 * that is common to all books.
 *
 * @author Henry Walker and David
 * @version 01/28/18
 */
public class Book {
    private String author;
    private String title;
    private String isbn;

    /**
     * Creates a book with the given information.
     *
     * @param author    The author(s) of the book
     * @param title     The title of the book
     * @param isbn      The ISBN of the book
     */
    public Book(String author, String title, String isbn) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
    }

    /**
     * @return The author of the book
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * @return  The title of the book
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return  The ISBN of the book
     */
    public String getISBN() {
        return this.isbn;
    }

    /**
     * Sets the book's author(s)
     * @param author    The book's specified author(s)
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the book's title
     * @param title Title of the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the ISBN of the book
     * @param isbn  The ISBN of the book
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Title: %s\n", title));
        sb.append(String.format("Author: %s\n", author));
        sb.append(String.format("ISBN: %s", isbn));
        return sb.toString();
    }
}
