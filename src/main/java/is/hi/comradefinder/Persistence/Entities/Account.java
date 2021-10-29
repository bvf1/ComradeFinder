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
    protected String displayName;
    @ElementCollection(fetch= FetchType.LAZY)
    protected List<String> description;
    // Description might want to be other type than List<String>

    // Abstract class does not initalize
    // No constructor needed.
    //
    // Methods that are common for User and Company should go here:
    // TODO: Getter and setter methods
}
