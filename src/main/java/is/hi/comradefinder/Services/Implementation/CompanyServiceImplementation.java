package is.hi.comradefinder.Services.Implementation;

import is.hi.comradefinder.Persistence.Entities.Company;
import is.hi.comradefinder.Persistence.Repositories.CompanyRepository;
import is.hi.comradefinder.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
public class CompanyServiceImplementation implements CompanyService {

    private CompanyRepository repository;

    @Autowired
    public CompanyServiceImplementation(CompanyRepository repository){
        this.repository = repository;
    }

    @Override
    public Company save(Company company) {
        return repository.save(company);
    }

    @Override
    public void delete(Company company) {
        repository.delete(company);
    }

    @Override
    public List<Company> findAll() {
        return repository.findAll();
    }


    @Override
    public Company findByUsername(String username) { return repository.findByUsername(username); }

    @Override
    public Company login(Company company) {
        Company doesExist = findByUsername(company.getUsername());
        if (doesExist != null) {
            if (doesExist.getPassword().equals(company.getPassword())) {
                return doesExist;
            }
        }
        return null;
    }


    @Override
    public Company findByID(Long id) {
        return repository.findByID(id);
    }
}
