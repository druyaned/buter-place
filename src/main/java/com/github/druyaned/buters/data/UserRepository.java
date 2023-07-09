package com.github.druyaned.buters.data;

import com.github.druyaned.buters.ButerUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ButerUser, Long> {

    ButerUser findByUsername(String username);

}
