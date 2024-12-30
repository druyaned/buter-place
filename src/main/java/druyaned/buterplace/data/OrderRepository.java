package druyaned.buterplace.data;

import druyaned.buterplace.ButerOrder;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<ButerOrder, Long> {
    
    List<ButerOrder> findByUsernameOrderByCreatedAtDesc(String username);
    
}
