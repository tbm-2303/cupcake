package business.entities;

public class Top {

    private int topId;
    private String name;
    private int price;


    public Top(int topId, String name, int price) {
        this.name = name;
        this.price = price;
        this.topId = topId;
    }

    public int getTopId() {
        return topId;
    }

    public void setTopId(int topId) {
        this.topId = topId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
