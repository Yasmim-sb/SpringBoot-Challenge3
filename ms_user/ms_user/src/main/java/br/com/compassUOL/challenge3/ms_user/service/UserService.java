package br.com.compassUOL.challenge3.ms_user.service;

import br.com.compassUOL.challenge3.ms_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

}
