package is.hi.comradefinder.Persistence.Entities;

import javax.persistence.*;

@Entity
@Table
public class Company {

    @Id
    private Long kennitala;
    private String name;
    private String email;

    public Company() {
    }

    public Company(Long kennitala, String name, String email) {
        this.kennitala = kennitala;
        this.name = name;
        this.email =email;
    }

    public Long getKennitala() {
        return kennitala;
    }

    public void setKennitala(Long kennitala) {
        this.kennitala = kennitala;
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
