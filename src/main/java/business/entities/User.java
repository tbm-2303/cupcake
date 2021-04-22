package business.entities;

public class User
{

    public User(String name,String email, String password, String role, int konto_id)
    {
        this.email = email;
        this.password = password;
        this.role = role;
        this.name = name;
        this.konto_id = konto_id;
    }


    private String name;
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private int konto_id;
    private int id; // just used to demo retrieval of autogen keys in UserMapper


    public int getKonto_id() {
        return konto_id;
    }

    public void setKonto_id(int konto_id) {
        this.konto_id = konto_id;
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
