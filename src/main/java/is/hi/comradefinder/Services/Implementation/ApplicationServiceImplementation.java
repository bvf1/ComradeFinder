package is.hi.comradefinder.Services.Implementation;

import is.hi.comradefinder.Persistence.Entities.Application;
import is.hi.comradefinder.Persistence.Repositories.ApplicationRepository;
import is.hi.comradefinder.Services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ApplicationServiceImplementation implements ApplicationService {

    private ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImplementation(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Application save(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public void delete(Application application) { applicationRepository.delete(application); }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    @Override
    public Optional<Application> findById(Long id) {
        return applicationRepository.findById(id);
    }


    @Override
    public List<Application> findByUser(String username) {
        return applicationRepository.findByUser(username);
    }

    @Override
    public List<Application> findByAd(String ad) { return applicationRepository.findByAd(ad); }
}
