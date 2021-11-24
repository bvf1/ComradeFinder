package is.hi.comradefinder.Persistence.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Application {
    @Id
    private long applicationID;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ad ad;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<String> extraInfo;

    public Application() {
        this(null, null, null);
    }
    public Application(User user, Ad ad, List<String> extraInfo) {
        this.user = user;
        this.ad = ad;
        this.extraInfo = extraInfo;
    }

    public long getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(long applicationID) {
        this.applicationID = applicationID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    public List<String> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(List<String> extraInfo) {
        this.extraInfo = extraInfo;
    }
}
