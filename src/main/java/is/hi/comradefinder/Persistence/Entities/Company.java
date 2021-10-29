package is.hi.comradefinder.Persistence.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company extends Account {

    private int SSN; // assigned -1 if missing
    private String street;
    private String companyPhone;
    @OneToMany(fetch= FetchType.LAZY)
    private List<Ad> advertisements;

    // TODO: Do we want to allow empty construction?
    // Constructor chain
    public Company() {
        this(null, null, null, null, null, null, -1, null, null);
    }
    public Company(String username, String password, String phone, String email, String displayName, List<String> description, int SSN, String street, String companyPhone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.displayName = displayName;
        this.description = description;
        this.SSN = SSN;
        this.street = street;
        this.companyPhone = companyPhone;
    }

    // TODO: Getters and setters
    public String getName() {
        return displayName;
    }

    public void setName(String name) {
        this.displayName = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
