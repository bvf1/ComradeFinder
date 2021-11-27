package is.hi.comradefinder.Services;

import is.hi.comradefinder.Persistence.Entities.Ad;
import is.hi.comradefinder.Persistence.Entities.Application;
import is.hi.comradefinder.Persistence.Entities.User;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    Application save(Application application);
    void delete(Application application);

    List<Application> findAll();
    Application findByID(Long id);

    List<Application> findByUser(User user);
    List<Application> findByAd(Ad ad);

    Optional<Application> findApplicationByUserAndAd(User user, Ad ad);
}
