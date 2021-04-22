package business.entities;

public class Cupcake {

    int cupcakeId;//?
    int topId;
    int bottomId;
    int amount;

    public Cupcake(int topId, int bottomId, int amount) {
        this.topId = topId;
        this.bottomId = bottomId;
        this.amount = amount;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
