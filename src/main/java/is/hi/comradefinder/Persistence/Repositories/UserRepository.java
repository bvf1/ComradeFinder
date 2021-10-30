package is.hi.comradefinder.Persistence.Repositories;

import is.hi.comradefinder.Persistence.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

        User save(User User);
        void delete(User User);

        List<User> findAll();
        //List<User> findByName(String name);

        User findByUsername(String username);
}
