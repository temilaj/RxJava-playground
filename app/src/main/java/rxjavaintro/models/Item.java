package rxjavaintro.models;

public class Item {
    public int id;

    public Item(int id)
    {
        this.id = id;
        System.out.println(String.format("Item Created %s", id));
        // System.out.println(String.format("Item Created %1$s", id));
    }
}
