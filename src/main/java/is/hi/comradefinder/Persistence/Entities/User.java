package is.hi.comradefinder.Persistence.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Account {
    private String PDFcv;
    @OneToMany(fetch= FetchType.LAZY)
    private List<Application> applications;

    // Constructor chain

    public User() {
    }

    public User(String username, String password, String phone, String email, String displayName, String description, String PDFcv) {
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

    public String getPDFcv() {
        return PDFcv;
    }

    public void setPDFcv(String PDFcv) {
        this.PDFcv = PDFcv;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
