package is.hi.comradefinder.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    public Company() {
    }

    public Company(String name, String email) {
        this.name = name;
        this.email =email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
