import java.util.ArrayList;

public class Store {
    private ArrayList<Sellable> items;

    public Store() {
        items = new ArrayList<Sellable>();
    }

    public void addItem(Sellable item) {
        items.add(item);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Sellable item : items){
            sb.append(String.format("%s, $%.2f\n", item.getDescription(), item.getPrice()));
        }
        return sb.toString();
    }
}
