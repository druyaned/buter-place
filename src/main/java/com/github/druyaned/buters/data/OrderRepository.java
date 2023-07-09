package com.github.druyaned.buters.data;

import com.github.druyaned.buters.ButerOrder;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<ButerOrder, Long> {
    
    List<ButerOrder> findByUsernameOrderByCreatedAtDesc(String username);
    
}
