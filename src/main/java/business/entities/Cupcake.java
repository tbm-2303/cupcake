package business.entities;

public class Cupcake {

    int cupcakeId;//?
    int topId;
    int bottomId;
    int price;

    public Cupcake(int topId, int bottomId, int price) {
        this.topId = topId;
        this.bottomId = bottomId;
        this.price = price;
    }





    public int getCupcakeId() {
        return cupcakeId;
    }

    public void setCupcakeId(int cupcakeId) {
        this.cupcakeId = cupcakeId;
    }

    public int getTopId() {
        return topId;
    }

    public void setTopId(int topId) {
        this.topId = topId;
    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
