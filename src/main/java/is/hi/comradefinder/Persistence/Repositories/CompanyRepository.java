package is.hi.comradefinder.Persistence.Repositories;

import is.hi.comradefinder.Persistence.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company save(Company company);
    void delete(Company company);

    List<Company> findAll();
    //List<Company> findByName(String name);

    Company findByUsername(String username);


   // List<Company> findAllByOrderByIdDesc();
    //Company findOne(Long id);

    /* Getum gert eigin queries
    @Query(value = "SELECT p FROM Company p where length(p.name) >= 3")
    List<Company> findAllWithNameLongerThan3Chars();
     */

}
