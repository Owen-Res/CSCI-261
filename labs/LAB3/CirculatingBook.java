public class CirculatingBook extends LibraryBook {
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String author, String title, String isbn, String callno) {
        super(author, title, isbn, callno);
    }

    public String getCurrentHolder() {
        return currentHolder;
    }

    public void setCurrentHolder(String currentHolder) {
        this.currentHolder = currentHolder;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public void checkout(String patron, String due) {
        if (currentHolder != null || dueDate != null)
            System.out.printf("book unavailable until %s\n", dueDate);
        else {
            currentHolder = patron;
            dueDate = due;
        }
    }

    @Override
    public String circulationStatus() {
        if (currentHolder != null || dueDate != null)
           return String.format("book checked out by %s and due back on %s", currentHolder, dueDate);
 
        return String.format("book available on shelves");
    }

    @Override
    public void returned() {
        currentHolder = null;
        dueDate = null;
    }

    @Override 
    public String toString(){
        return String.format("%s\n%s", super.toString(), circulationStatus());
    }
}
