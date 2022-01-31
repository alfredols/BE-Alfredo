package br.com.api.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.user.data.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {	

}

