package is.hi.comradefinder.Persistence.Repositories;

import is.hi.comradefinder.Persistence.Entities.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdRepository extends JpaRepository<Ad, Long> {

    Ad save(Ad Ad);
    void delete(Ad Ad);

    List<Ad> findAll();
    Optional<Ad> findById(Long Id);

    List<Ad> findByTitle(String Title);
    List<Ad> findByTagsContaining(String Tag);
    @Query(value = "SELECT p FROM Ad p WHERE Ad.company.username = ?1")
    List<Ad> findByCompany(String username);

}
