package is.hi.comradefinder.Persistence.Repositories;

import is.hi.comradefinder.Persistence.Entities.Ad;
import is.hi.comradefinder.Persistence.Entities.Application;
import is.hi.comradefinder.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Application save(Application application);
    void delete(Application application);

    List<Application> findAll();
    Application findByID(Long id);

    // TODO: Input parameters are not okie dokie
    List<Application> findByUser(String username);
    List<Application> findByAd(String ad);

    Optional<Application> findApplicationByUserAndAd(User user, Ad ad);
}
