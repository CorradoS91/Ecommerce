package it.corrado.repository;

import it.corrado.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User,Long> {

    Optional <User> getUserByEmail(String email);

    Optional <User> getUserById(Long id);

    void deleteUserByEmail(String email);

}
