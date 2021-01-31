package com.sorteioapp.sorteioapp.repository;

import com.sorteioapp.sorteioapp.models.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, String> {

     User findByEmail(String email);

}

