package br.com.compassUOL.challenge3.ms_user.repository;


import br.com.compassUOL.challenge3.ms_user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String login);
    UserDetails findByCpf(String cpf);
}
