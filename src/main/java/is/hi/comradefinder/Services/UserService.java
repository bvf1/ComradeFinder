package is.hi.comradefinder.Services;

import is.hi.comradefinder.Persistence.Entities.User;

import java.util.List;

public interface UserService {


    User save(User User);
    void delete(User User);

    List<User> findAll();
    //List<User> findByName(String name);

    User findByUsername(String username);
    List<User> findAllReverseOrder();

    User login(User user);
}
