import java.util.List;
import java.io.Console;

public class Account {
    private String name;
    private String surname;
    private String username;
    private String password;

    public Account() {
        this.name = "";
        this.surname = "";
        this.username = "";
        this.password = "";
    }

    public Account(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public String toString() {
        String result;

        result = "\n####################################";
        result += "\n# name = " + name;
        result += "\n# surname = " + surname;
        result += "\n# username = " + username;
        result += "\n# password = " + password;
        result += "\n####################################";
        return result;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    public String getName() {
        return this.name;
    }    
    public String getSurname() {
        return this.surname;
    }
    
}
