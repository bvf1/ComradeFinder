package is.hi.comradefinder.Services;

import is.hi.comradefinder.Persistence.Entities.User;

import java.util.List;

public interface UserService {


    User save(User User);
    void delete(User User);

    User findByUsername(String username);
    User login(User user);
    User findByID(Long id);

}
