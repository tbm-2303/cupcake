package business.entities;

public class User
{
    private String name;
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private int balance;
    private int id; // just used to demo retrieval of autogen keys in UserMapper

    public User(String name,String email, String password, String role, int balance)
    {
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.balance = balance;
    }


    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
