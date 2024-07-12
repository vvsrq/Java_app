package warehouse.model;

public class Good {
    private int id;
    private String name;
    private int quantity;

    public Good(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Good() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
