package br.edu.ifpb.bicos.repository;

import br.edu.ifpb.bicos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
