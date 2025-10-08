/**
 * This abstract class models a library book.
 * There are concrete methods that still need to be provided by you!
 * @author David
 * @version 9/16/2019
 */
public abstract class LibraryBook extends Book implements Comparable<LibraryBook>
{
    private String callno;
    
    /**
     * Creates a new library book with the given information.
     * 
     * @param author    Author of the library book
     * @param title     Title of the library book
     * @param isbn      ISBN number of the library book
     * @param callno    Call number of the library book
     */
    public LibraryBook(String author, String title, String isbn, String callno) {
        super(author, title, isbn);
        this.callno = callno;
    }

    /**
     * @return  The book's call number
     */
    public String getCallNo() {
        return this.callno;
    }
    
    /**
     * Sets the book's call number
     * @param callno the specified call number for this library book
     */
    public void setCallNo(String callno) {
        this.callno = callno;
    }
    
    /**
     * @return a pretty string for the library book, which includes a call number
     */
    @Override
    public String toString() {
        return String.format("%s\nCall number: %s", super.toString(), callno);
    }
    
    /**
     * Determines whether this library book is equal to another. Two library
     * books are equal if their call numbers are equal.
     * 
     * @param other Another library book
     */
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof LibraryBook))
            return false;
        
        return ((LibraryBook)other).callno.equals(callno);
    }
    

    @Override
    public int compareTo(LibraryBook other){
        return callno.compareTo(other.callno);
    }   
    /**
     * This method eventually handles processing for a patron to check out a 
     * book. A due date also is recorded.
     */
    public abstract void checkout(String patron, String due);
    
    /**
     * This method eventually handles processing for when a book is returned 
     * after having been checked out.
     */
    public abstract void returned();
    
    /**
     * This method will eventually indicate whether the book is on the 
     * shelves, checked, or non-circulating in the reference collection.
     */
    public abstract String circulationStatus();
}
