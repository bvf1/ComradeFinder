package is.hi.comradefinder.Services;

import is.hi.comradefinder.Persistence.Entities.Company;

import java.util.List;

public interface CompanyService {
    Company save(Company company);
    void delete(Company company);

    List<Company> findAll();
    List<Company> findAllReverseOrder();
   // List<Company> findByName(String name);
    Company findByUsername(String username);

    Company login(Company company);
    /*
    List<Company> findAllReverseOrder();
    Company findOne(Long id);
    List<Company> findByName(String name);
    */
}
