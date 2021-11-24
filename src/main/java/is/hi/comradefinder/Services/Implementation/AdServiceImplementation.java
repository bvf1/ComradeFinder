package is.hi.comradefinder.Services.Implementation;

import is.hi.comradefinder.Persistence.Entities.Ad;
import is.hi.comradefinder.Persistence.Repositories.AdRepository;
import is.hi.comradefinder.Services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AdServiceImplementation implements AdService {

    private AdRepository repository;

    @Autowired
    public AdServiceImplementation(AdRepository repository){
        this.repository = repository;
    }

    @Override
    public Ad save(Ad ad) {
        return repository.save(ad);
    }

    @Override
    public void delete(Ad ad) {
        repository.delete(ad);
    }


    @Override
    public List<Ad> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Ad> findByID(Long id) { return repository.findById(id); }


    @Override
    public List<Ad> findByTitle(String title) { return repository.findByTitle(title); }

    @Override
    public List<Ad> findByTagsContaining(String tag) { return repository.findByTagsContaining(tag); }

    @Override
    public List<Ad> findAdsByCompany(String username) { return repository.findAdsByCompany_Username(username); }

}
