package is.hi.Services;

import is.hi.Persistence.Entities.Company;

import java.util.List;

public interface CompanyService {
    Company save(Company company);
    void delete(Company company);
    List<Company> findAll();
    List<Company> findAllReverseOrder();
    Company findOne(Long kennitala);
    List<Company> findByName(String name);
}
