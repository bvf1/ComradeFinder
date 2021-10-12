package is.hi.comradefinder.Persistence.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ad<id> {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
