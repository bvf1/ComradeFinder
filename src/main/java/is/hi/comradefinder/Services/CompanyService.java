package is.hi.comradefinder.Services;

import is.hi.comradefinder.Persistence.Entities.Company;

import java.util.List;

public interface CompanyService {
    Company save(Company company);
    void delete(Company company);

    Company findByUsername(String username);

    Company login(Company company);

    List<Company> findAll();
    Company findByID(Long id);
}
