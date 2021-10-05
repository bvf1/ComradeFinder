package is.hi.comradefinder.Persistence.Repositories;

import is.hi.comradefinder.Persistence.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company save(Company company);
    void delete(Company company);
    List<Company> findAll();

    /* Getum gert eigin queries
    @Query(value = "SELECT p FROM Company p where length(p.name) >= 3")
    List<Company> findAllWithNameLongerThan3Chars();
     */

    List<Company> findAllByOrderByKennitalaDesc();
    Company findOne(Long Kennitala);
    List<Company> findByName(String name);


}
