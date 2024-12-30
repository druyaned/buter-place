package druyaned.buterplace.data;

import druyaned.buterplace.ButerUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ButerUser, Long> {
    
    ButerUser findByUsername(String username);
    
}
