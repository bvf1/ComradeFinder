package is.hi.comradefinder.Services;

import is.hi.comradefinder.Persistence.Entities.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    Application save(Application application);
    void delete(Application application);

    List<Application> findAll();
    Application findByID(Long id);

    List<Application> findByUser(String username);
    List<Application> findByAd(String ad);
}
