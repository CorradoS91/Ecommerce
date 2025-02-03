package it.corrado.repository;

import it.corrado.model.UserAddress;
import it.corrado.model.User;
import it.corrado.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

    // Trova tutti gli indirizzi associati a un utente
    List<UserAddress> findByUser(User user);

    // Trova tutti gli utenti associati a un indirizzo
    List<UserAddress> findByAddress(Address address);

    // Trova un'associazione specifica tra un utente e un indirizzo
    Optional<UserAddress> findByUserAndAddress(User user, Address address);

    // Verifica se un indirizzo primario esiste per un determinato utente
    Optional<UserAddress> findByUserAndIsPrimaryTrue(User user);
}
