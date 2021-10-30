package is.hi.comradefinder.Services.Implementation;

import is.hi.comradefinder.Persistence.Entities.User;
import is.hi.comradefinder.Services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{
    @Override
    public User save(User User) {
        return null;
    }

    @Override
    public void delete(User User) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }
}
