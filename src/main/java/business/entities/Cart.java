package business.entities;

public class Cart {

    private int cartId;
    private String name;

    public Cart(String name) {
        this.name = name;
    }


    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
