import java.util.ArrayList;

public class Library {
    private ArrayList<LibraryBook> books;

    public Library() {
        books = new ArrayList<LibraryBook>();
    }

    public void addBook(LibraryBook book) {
        books.add(book);
    }

    public void printLibrary() {
        System.out.println("Listing of books in the library\n");
        for (LibraryBook lb : books) {
            System.out.printf("%s\n\n", lb);
        }
        System.out.println("End of book listing");
    }

    public LibraryBook findBook(LibraryBook book) {
        for (LibraryBook lb : books) {
            if (lb.equals(book)) {
                return lb;
            }
        }

        return null;
    }

    void checkout(String patron, String due, String callno) {
        ReferenceBook searchKey = new ReferenceBook("", "", "", callno, "");
        LibraryBook candidate = findBook(searchKey);

        if (candidate == null)
            System.out.printf("Book %s not found -- check out impossible\n", callno);
        else {
            candidate.checkout(patron, due);
        }
    }

    void returned(String callno) {
        ReferenceBook searchKey = new ReferenceBook("", "", "", callno, "");
        LibraryBook candidate = findBook(searchKey);

        if (candidate == null)
            System.out.printf("Book %s not found -- return impossible\n", callno);
        else {
            candidate.returned();
        }
    }
}
