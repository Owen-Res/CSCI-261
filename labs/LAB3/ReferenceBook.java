public class ReferenceBook extends LibraryBook {
    private String collection;

    public ReferenceBook(String author, String title, String isbn, String callno, String collection) {
        super(author, title, isbn, callno);
        this.collection = collection;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    @Override
    public void checkout(String patron, String due) {
        System.out.println("cannot check out a reference book");
    }

    @Override
    public void returned(){
        System.out.println("reference book could not have been checked out -- return impossible");
    }

    @Override
    public String circulationStatus(){
        return "non-circulating reference book";
    }

    @Override
    public String toString(){
        return String.format("%s\nCollection: %s", super.toString(), collection);
    }

}
