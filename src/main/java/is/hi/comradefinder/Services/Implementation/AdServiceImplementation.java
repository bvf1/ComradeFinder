package is.hi.comradefinder.Services.Implementation;

import is.hi.comradefinder.Persistence.Entities.Ad;
import is.hi.comradefinder.Persistence.Entities.Application;
import is.hi.comradefinder.Persistence.Repositories.AdRepository;
import is.hi.comradefinder.Persistence.Repositories.ApplicationRepository;
import is.hi.comradefinder.Services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AdServiceImplementation implements AdService {

    private AdRepository repository;
    private ApplicationRepository appRepository;

    @Autowired
    public AdServiceImplementation(AdRepository repository, ApplicationRepository appRepository){
        this.repository = repository;
        this.appRepository = appRepository;
    }

    @Override
    public Ad save(Ad ad) {
        return repository.save(ad);
    }

    @Override
    public void delete(Ad ad) {
        List<Application> apps = appRepository.findAll();
        for (Application app : apps) {
            if (app.getAd().getID() == ad.getID()) {
                appRepository.delete(app);
            }
        }
        repository.delete(ad);
    }


    @Override
    public List<Ad> findAll() {
        return repository.findAll();
    }

    @Override
    public Ad findByID(Long id) {return repository.findByID(id);}


    @Override
    public List<Ad> findByTitle(String title) { return repository.findByTitle(title); }

    @Override
    public List<Ad> findByTagsContaining(String tag) { return repository.findByTagsContaining(tag); }

    @Override
    public List<Ad> findAdsByCompany(String username) { return repository.findAdsByCompany_Username(username); }

}
