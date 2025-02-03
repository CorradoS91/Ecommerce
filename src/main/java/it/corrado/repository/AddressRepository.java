package it.corrado.repository;

import it.corrado.model.Address;
import it.corrado.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUsersSet(User user);

}
