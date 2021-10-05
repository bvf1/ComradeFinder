package is.hi.Services.Implementation;

import is.hi.Persistence.Entities.Company;
import is.hi.Persistence.Repositories.CompanyRepository;
import is.hi.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
public class CompanyServerImplementation implements CompanyService {
    CompanyRepository repository;

    @Autowired
    public CompanyServerImplementation (CompanyRepository repository){
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
    public List<Company> findAllReverseOrder() {
        List<Company> company = repository.findAll();

        Collections.reverse(company);
        return company;
    }

    @Override
    public Company findOne(Long kennitala) {
        return repository.findOne(kennitala);
    }

    @Override
    public List<Company> findByName(String name) {
        return repository.findByName(name);
    }
}
