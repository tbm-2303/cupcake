package business.entities;

public class Bottom {

    private int bottomId;
    private String name;
    private int price;

    public Bottom(int bottomID, String name, int price) {
        this.name = name;
        this.price = price;
        this.bottomId = bottomID;

    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
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
