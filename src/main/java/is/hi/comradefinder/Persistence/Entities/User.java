package is.hi.comradefinder.Persistence.Entities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User extends Account {
    @OneToMany(fetch= FetchType.LAZY)
    private List<Application> applications;
    private String PDFcv;

    // TODO: Do we want to allow empty construction?
    // Constructor chain
    public User() {
        this(null, null, null, null, null, null, null);
    }
    public User(String username, String password, String phone, String email, String displayName, List<String> description, String PDFcv) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.displayName = displayName;
        this.description = description;
        this.PDFcv = PDFcv;
    }

    public void addCV(String newPDFLink) {
        this.PDFcv = newPDFLink;
    }

    // TODO: Getters and setters
}
