package br.edu.ifpb.bicos.service;

import br.edu.ifpb.bicos.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
