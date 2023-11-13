package br.com.compassUOL.challenge3.ms_user.repository;

import br.com.compassUOL.challenge3.ms_user.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
