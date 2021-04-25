package business.entities;

public class Cupcake {

    Top top;
    Bottom bot;
    int amount;
    int price;

    public Cupcake(Top top, Bottom bot, int amount) {
        this.top = top;
        this.bot = bot;
        this.amount = amount;
    }

    public Top getTop() {
        return top;
    }

    public void setTop(Top top) {
        this.top = top;
    }

    public Bottom getBot() {
        return bot;
    }

    public void setBot(Bottom bot) {
        this.bot = bot;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return ((this.bot.getPrice() + this.top.getPrice()) * amount);
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
