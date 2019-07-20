package br.edu.ifpb.bicos.service;

import br.edu.ifpb.bicos.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(User registration);
}
