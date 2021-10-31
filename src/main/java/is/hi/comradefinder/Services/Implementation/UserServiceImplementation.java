package is.hi.comradefinder.Services.Implementation;

import is.hi.comradefinder.Persistence.Entities.User;
import is.hi.comradefinder.Persistence.Repositories.UserRepository;
import is.hi.comradefinder.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    private UserRepository repository;

    @Autowired
    public UserServiceImplementation(UserRepository repository){
        this.repository = repository;
    }



    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }


    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User login(User user) {
        User doesExist = findByUsername(user.getUsername());
        if (doesExist != null) {
            if (doesExist.getPassword().equals(user.getPassword())) {
                return doesExist;
            }
        }
        return null;
    }

    @Override
    public User findByID(Long id) {
        return this.repository.findByID(id);
    }
}
