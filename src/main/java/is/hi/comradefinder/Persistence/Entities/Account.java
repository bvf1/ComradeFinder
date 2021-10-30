package is.hi.comradefinder.Persistence.Entities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.List;

@Entity
public abstract class Account {
    @Id
    protected long id;
    protected String username;
    protected String password;
    protected String phone;
    protected String email;
    protected String displayName; // what is displayName
    @ElementCollection(fetch= FetchType.LAZY)
    protected List<String> description;
    // Description might want to be other type than List<String>

    // Abstract class does not initalize
    // No constructor needed.
    //
    // Methods that are common for User and Company should go here:
    // TODO: Getter and setter methods

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

}
