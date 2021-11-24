package is.hi.comradefinder.Persistence.Repositories;

import is.hi.comradefinder.Persistence.Entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Application save(Application application);
    void delete(Application application);

    List<Application> findAll();
    Optional<Application> findById(Long id);

    List<Application> findByUser(String username);
    List<Application> findByAd(String ad);
}
